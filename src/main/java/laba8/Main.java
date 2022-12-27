package laba8;

public class Main {

    private final static String FILE_NAME = "strings.xml";
    private final static String INPUT_TEXT_FILE_NAME = "super.txt";

    private final static ServiceByMartaAndLialkouskaya SERVICE = new ServiceByMartaAndLialkouskaya();

    public static void main(String[] args) {
        try {
            MySuperArrayList mySuperArrayList = new MySuperArrayList(5);
            mySuperArrayList.add("one");
            mySuperArrayList.add("one");
            mySuperArrayList.add("two");
            mySuperArrayList.add("one");
            mySuperArrayList.add("one");
            mySuperArrayList.remove(0);
            SERVICE.showDuplicatesWithCount(mySuperArrayList);
            SERVICE.writeListToXml(mySuperArrayList, FILE_NAME);
            SERVICE.reverseAll(mySuperArrayList);
            SERVICE.showCharsStatistic(mySuperArrayList);
            System.out.println("Index of elem with substring 'eno' "
                    +SERVICE.findStrIdBySubstring(mySuperArrayList, "eno"));
            MySuperArrayList list2 = SERVICE.readFileToSuperListAndPrint(INPUT_TEXT_FILE_NAME);
            System.out.println("Second list: ");
            list2.forEach(System.out::println);
            System.out.println("compare 1 and 2 elemets: "+list2.compareInnerObjects(1, 2));
            SERVICE.showStringLengths(list2);
            mySuperArrayList.add("two");
            mySuperArrayList.add("two");
            mySuperArrayList.add("two");
            System.out.println("Max size = 5, added 8, removed 1. Final list: ");
            mySuperArrayList.forEach(System.out::println);
        }catch (Exception ex){
            System.out.println("Some exception occurred: "+ex.getMessage());
        }
    }
}
