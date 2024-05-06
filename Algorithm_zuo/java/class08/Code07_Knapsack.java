package class08;

public class Code07_Knapsack {
    

    public static int function(int[] weights, int[] values, int bag){
        if(weights == null || values == null || (weights.length != values.length)){
            return 0;
        }
        return process2(weights, values, 0, 0, 0, bag);
    }

    public static int process2(int[] weights, int[] values,
            int i, int alreadyWeight, int alreadyValue, int bag){
        if(alreadyWeight > bag){
            return 0;
        }
        if(i == values.length){
            return alreadyValue;
        }
        return Math.max(
        process2(weights, values, i + 1, alreadyWeight, alreadyValue, bag), 
        process2(weights, values, i + 1, alreadyWeight + weights[i], alreadyValue + values[i], bag)
        );
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5};
        int[] value = {30, 8, 12, 4, 20};
        int bag = 10;
        System.out.println(function(weights, value, bag));
    }


}
