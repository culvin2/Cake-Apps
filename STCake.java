import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class STcase
{
    String name;
    String street;
    String Caption;

    String[] Cake = {
        "Rainbow Cake",
        "Lapis Surabaya",
        "Brownies Cake",
        "Coconut Cake"
    };

    Integer option;

    String cakeCode;

    HashMap<Integer, String> CakeList = new HashMap<Integer, String>();
    HashMap<String, String> CakeCode = new HashMap<String, String>();
    HashMap<String, String> CakePrice = new HashMap<String, String>();

    public void DataInsert()
    {
        String nm,add;
        do
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Please input your name [3..20] : ");
            nm = input.nextLine();
            name = nm;
        }
        while(nm.length() < 3 || nm.length() > 20);
        
        do
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Please input your address [ends with 'street'] : ");
            add = input.nextLine();
            street = add;
        }
        while(!add.contains("Street"));
    }

    public void GenerateCakeData()
    {
        int cakesum = 4;

        for(int i = 0; i < cakesum; i++)
        {
            GenerateCakeCode();
            CakeList.put(i+1, cakeCode);
            CakeCode.put(cakeCode, Cake[i]);
        }

        CakePrice.put("Rainbow Cake","250.000");
        CakePrice.put("Lapis Surabaya","324.000");
        CakePrice.put("Brownies Cake","387.000");
        CakePrice.put("Coconut Cake","420.000");
    }

    void GenerateCakeCode()
    {
        Random random = new Random();
        int x,y,z;
        
        x = random.nextInt(10);
        y = random.nextInt(10);
        z = random.nextInt(10);

        cakeCode = "CK" + x + y + z;
    }

    void DisplayData(int _cakeID, String _caption)
    {
        String caption = _caption;
        String respond;

        int cakeID = _cakeID;


        String cakeCode = CakeList.get(cakeID);
        String cakeType = CakeCode.get(cakeCode);
        String cakePrice = CakePrice.get(cakeType);

        System.out.println("Your Choise is number " + cakeID);
        System.out.println("=======================");
        System.out.println("Cake Code        : " + cakeCode);
        System.out.println("Cake Type        : " + cakeType);
        System.out.println("Cake Price       : " + cakePrice);
        System.out.println("Cake Caption     : " + caption);
        System.out.print("Do you want to order again?[Y/N]: ");

        try
        {
            Scanner input = new Scanner(System.in);
            respond = input.nextLine();
        }
        catch(Exception exception)
        {
            respond = null;
        }

        if(respond.equals("Y")|| respond.equals("y") )
        {
            return;
        }
        else if(respond.equals("N")|| respond.equals("n") )
        {
            System.exit(0);
        }
    }

    public void CakeInfo(int Id)
    {
        int ID = Id;
        String capt;
        do
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Input Cake Caption [10..35] : ");
            capt = input.nextLine();
            Caption = capt;
        }
        while(capt.length() < 10 || capt.length() > 35);
        DisplayData(ID, capt);
    }

    public void Menu()
    {
        System.out.println("Welcome : " + name);
        System.out.println("Your address : " + street);
        System.out.println("Cake List :");
        System.out.println("===========");
        System.out.println("1. Rainbow Cake");
        System.out.println("2. Lapis Surabaya");
        System.out.println("3. Brownies Cake");
        System.out.println("4. Coconut Cake");
        System.out.println("5. Exit");
        System.out.print("Please Imput your cake [1..5] : ");

        try
        {
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
        }
        catch(Exception exception)
        {
            option = 0;
        }
    }

    public static void main(String[] args)
    {
        STcase main = new STcase();
        main.DataInsert();
        main.GenerateCakeData();
        while(true)
        {
            main.Menu();
            switch(main.option)
            {
                case 1:
                    System.out.println("\n");
                    main.CakeInfo(main.option);
                    break;
                case 2:
                    System.out.println("\n");
                    main.CakeInfo(main.option);
                    break;
                case 3:
                    System.out.println("\n");
                    main.CakeInfo(main.option);
                    break;
                case 4:
                    System.out.println("\n");
                    main.CakeInfo(main.option);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}