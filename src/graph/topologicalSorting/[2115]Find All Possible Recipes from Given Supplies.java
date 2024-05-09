package graph.topologicalSorting;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class FindAllRecipesSolution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        List<String> res = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        for(int i = 0;i<recipes.length;i++){
            String recipe = recipes[i];
            List<String> materials = ingredients.get(i);
            for(String material:materials){
                if(!graph.containsKey(material)){
                    graph.put(material, new ArrayList<>());
                }
                graph.get(material).add(recipe);
                indegree.put(recipe, indegree.getOrDefault(recipe, 0)+1);
            }
        }
        for(String supply:supplies){
            queue.offer(supply);
        }
        while(!queue.isEmpty()){
            String ingredient=queue.poll();
            if(graph.containsKey(ingredient)){
                //no products can be made by this ingredient
                for(String product:graph.get(ingredient)){
                    indegree.put(product, indegree.get(product)-1);
                    if(indegree.get(product)==0){
                        res.add(product);
                        queue.offer(product);
                    }
                }
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
