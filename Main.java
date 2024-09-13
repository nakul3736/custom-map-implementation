import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Testing for UPDATE case
        CustomMap<Integer, String> numbers = new CustomMap<Integer, String>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");

        // now putting the pair with the duplicate key.
        numbers.put(2, "five");
        // it should be "five"
        System.out.println(numbers.get(2));

        // it should print null in the console because we don't have the key that we are looking for.
        System.out.println(numbers.get(30));

        // this should print the size of map
        System.out.println(numbers.size());

        // this should print true because we have the key 2
        System.out.println(numbers.contains(2));

        // this should print false because the key is not present
        System.out.println(numbers.contains(99));

        // Testing with custom class as a key
        class myObj {
            int age;
            String name;

            myObj(int age, String name) {
                this.age = age;
                this.name = name;
            }
        }

        // testing if the map will consider two separate identical object as one or not
        myObj temp1 = new myObj(1, "John");
        myObj temp2 = new myObj(1, "John");

        Map<myObj, String> map = new HashMap<>();
        map.put(temp1,"John one");
        map.put(temp2,"John two");
        // it should be 2 because temp1 and temp2 are two different object.
        System.out.println(map.size());

        myObj temp3 = temp1;
        // this should not chang the size of the map instead it should update the value of the key "temp1"
        map.put(temp3, "John three");

        System.out.println(map.size());
        System.out.println(map.get(temp3));

    }
}