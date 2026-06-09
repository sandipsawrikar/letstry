package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalAmountGorupByCategory
{
    public static void main(String[] args) {
        List<Transaction>  transactions = Arrays.asList(new Transaction("Food",2000),
                new Transaction("Food",3000),new Transaction("Food",4000),
                new Transaction("Shopping",2000),
                new Transaction("Shopping",7000),new Transaction("Shopping",1000),
                new Transaction("Travel",1000),new Transaction("Travel",6000),
                new Transaction("Food",2000));

        Map<String, Integer> collect = transactions.stream().collect(Collectors.groupingBy(Transaction::getCategory, Collectors.summingInt(Transaction::getAmount)));

        Map<String, Double> avgExpense = transactions.stream().collect(Collectors.groupingBy(Transaction::getCategory, Collectors.averagingInt(Transaction::getAmount)));


        System.out.println(collect);

        System.out.println(avgExpense);
    }
}
