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

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import aa.cc.ContainerStrengthComparator;
import aa.cc.ItemDifficultyComparator;
import aa.dd.AbstractPersistable;

@PlanningEntity(difficultyComparatorClass = ItemDifficultyComparator.class)
@XStreamAlias("CloudProcess")
public class Item extends AbstractPersistable {
	/*
    private int requiredCpuPower; // in gigahertz
    private int requiredMemory; // in gigabyte RAM
    private int requiredNetworkBandwidth; // in gigabyte per hour
	*/

	private int size;

    private Container container;
	
	
    public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	

    
    
    /*
    public int getRequiredCpuPower() {
        return requiredCpuPower;
    }

    public void setRequiredCpuPower(int requiredCpuPower) {
        this.requiredCpuPower = requiredCpuPower;
    }

    public int getRequiredMemory() {
        return requiredMemory;
    }

    public void setRequiredMemory(int requiredMemory) {
        this.requiredMemory = requiredMemory;
    }

    public int getRequiredNetworkBandwidth() {
        return requiredNetworkBandwidth;
    }

    public void setRequiredNetworkBandwidth(int requiredNetworkBandwidth) {
        this.requiredNetworkBandwidth = requiredNetworkBandwidth;
    }
    */
    
    @PlanningVariable(valueRangeProviderRefs = "computerRange",
            strengthComparatorClass = ContainerStrengthComparator.class)
    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
    
    
    public int getRequiredMultiplicand() {
        return size;
    }

    public String getLabel() {
        return "Item " + id;
    }
    
    public boolean solutionEquals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Item) {
        	Item other = (Item) o;
            return new EqualsBuilder()
                    .append(id, other.id)
                    .append(container, other.container)
                    .isEquals();
        } else {
            return false;
        }
    }
    
    
    public int solutionHashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(container)
                .toHashCode();
    }
    
    @Override
    public String toString() {
        return getLabel() + "->" + container;
    }
    

    // ************************************************************************
    // Complex methods
    // ************************************************************************
    /*
    public int getRequiredMultiplicand() {
        return requiredCpuPower * requiredMemory * requiredNetworkBandwidth;
    }

    public String getLabel() {
        return "Process " + id;
    }

    /**
     * The normal methods {@link #equals(Object)} and {@link #hashCode()} cannot be used because the rule engine already
     * requires them (for performance in their original state).
     * @see #solutionHashCode()
     
    public boolean solutionEquals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof CloudProcess) {
            CloudProcess other = (CloudProcess) o;
            return new EqualsBuilder()
                    .append(id, other.id)
                    .append(computer, other.computer)
                    .isEquals();
        } else {
            return false;
        }
    }

    /**
     * The normal methods {@link #equals(Object)} and {@link #hashCode()} cannot be used because the rule engine already
     * requires them (for performance in their original state).
     * @see #solutionEquals(Object)
     
    public int solutionHashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(computer)
                .toHashCode();
    }

    @Override
    public String toString() {
        return getLabel() + "->" + computer;
    }
    */
    
}
