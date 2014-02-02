/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aa.bb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.value.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.buildin.hardsoft.HardSoftScoreDefinition;
import org.optaplanner.core.impl.solution.Solution;
import aa.dd.AbstractPersistable;
import org.optaplanner.persistence.xstream.XStreamScoreConverter;

@PlanningSolution
@XStreamAlias("CloudBalance")
public class BinPack extends AbstractPersistable implements Solution<HardSoftScore> {

    private List<Container> containerList;

    private List<Item> itemList;

    @XStreamConverter(value = XStreamScoreConverter.class, types = HardSoftScoreDefinition.class)
    private HardSoftScore score;

    @ValueRangeProvider(id = "computerRange")
    public List<Container> getContainerList() {
        return containerList;
    }

    public void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
    }

    @PlanningEntityCollectionProperty
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

    public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(containerList);
        // Do not add the planning entity's (processList) because that will be done automatically
        return facts;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (id == null || !(o instanceof BinPack)) {
            return false;
        } else {
        	BinPack other = (BinPack) o;
            if (itemList.size() != other.itemList.size()) {
                return false;
            }
			Iterator<Item> it = itemList.iterator();
			otherIt = other.itemList.iterator();
            while(it.hasNext()){
                Item item = it.next();
                Item otherItem = otherIt.next();
                // Notice: we don't use equals()
                if (!item.solutionEquals(otherItem)) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        for (Item it : itemList) {
            // Notice: we don't use hashCode()
            hashCodeBuilder.append(it.solutionHashCode());
        }
        return hashCodeBuilder.toHashCode();
    }

}
