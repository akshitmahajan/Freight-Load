/*
 * Copyright 2012 JBoss Inc
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

package aa.ee;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.XmlSolverFactory;
import aa.bb.BinPack;
import aa.bb.Container;
import aa.bb.Item;


public class BinPackingHelloWorld {

    public String optaController(Integer truck_count,Integer truck_capacity,Integer freight_count,Integer freight_weight) {
    	System.out.println("in main");
    	
        // Build the Solver
		
        SolverFactory solverFactory = new XmlSolverFactory(
                "/aa/res/cd/binPackingSolverConfig.xml");
        Solver solver = solverFactory.buildSolver();

        List<Item> itemList = new ArrayList<Item>();
        
        for(int i=1; i<=freight_count; i++){
        
            Item item = new Item();
            item.setSize(freight_weight)
            item.setId(i);
            itemList.add(item);
        }
        
        /*Item item1 = new Item();
        item1.setSize(58);
        item1.setId(1L);
        
        Item item2 = new Item();
        item2.setSize(38);
        item2.setId(2L);
        
        Item item3 = new Item();
        item3.setSize(72);
        item3.setId(3L);
        
        Item item4 = new Item();
        item4.setSize(26);
        item4.setId(4L);
        
        Item item5 = new Item();
        item5.setSize(66);
        item5.setId(5L);
        
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);*/

        List<Container> containerList = new ArrayList<Container>();
        
        for(int j=1; j<=truck_count; j++){
        
            Container cont = new Container();
            cont.setCapacity(truck_capacity);
            cont.setUsed(10);
            cont.setId(j);
            containerList.add(cont);
        }
        
        /*Container cont1 = new Container();
        cont1.setCapacity(200);
        cont1.setUsed(10);
        cont1.setId(1L);
        
        Container cont2 = new Container();
        cont2.setCapacity(100);
        cont2.setUsed(10);
        cont2.setId(2L);
        
        Container cont3 = new Container();
        cont3.setCapacity(100);
        cont3.setUsed(10);
        cont3.setId(3L);
        
        Container cont4 = new Container();
        cont4.setCapacity(100);
        cont4.setUsed(10);
        cont4.setId(2L);
        
        containerList.add(cont1);
        containerList.add(cont2);
        containerList.add(cont3);
        containerList.add(cont4);*/

        BinPack unsolvedBinPack = new BinPack();
        unsolvedBinPack.setContainerList(containerList);
        unsolvedBinPack.setItemList(itemList);
        unsolvedBinPack.setId(0L);
        // Load a problem with 400 computers and 1200 processes
        //CloudBalance unsolvedCloudBalance = new CloudBalancingGenerator().createCloudBalance(400, 1200);

        // Solve the problem
        solver.setPlanningProblem(unsolvedBinPack);
        solver.solve();
        BinPack solvedBinPack = (BinPack) solver.getBestSolution();

        // Display the result
        System.out.println("\nSolved bin packing:\n"
                + toDisplayString(solvedBinPack));
        String result = toDisplayString(solvedBinPack);
        if(result!=null){
            println "The result is : "+result
            return result;
        }
        else return null;
    }

    public static String toDisplayString(BinPack binPack) {
        StringBuilder displayString = new StringBuilder();
        HardSoftScore score = binPack.getScore();
        displayString.append("Hard Score: "+score.getHardScore()+"\nSoft Score: "+score.getSoftScore()+"\n")
        System.out.println("Hard Score: "+score.getHardScore()+"\nSoft Score: "+score.getSoftScore()+"\n");
        for (Item item : binPack.getItemList()) {
            Container container = item.getContainer();
            displayString.append("  ").append(item.getLabel()).append(" -> ")
                    .append(container == null ? null : container.getLabel()).append("\n");
        }
        return displayString.toString();
    }
	
}
