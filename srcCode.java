
import java.io.*;
import java.lang.*;
import java.util.*;
import java.text.*;

public class air 
{
    String from,to,S[],N[],d_date,r_date;
    int RATE[]=new int[50];
    int seat[]=new int[200];
    String airways[]=new String[50];
    String reach_time[]=new String[50];
    String dept_time[]=new String[50];
    String ticket_used[]=new String[50];
      String name[]=new String[50];
      double Grand_total;
    //String ticket_nos[]=new String[50];
    
    int choice,day1,month1,year1,c=0,total_seats,check=0, tripchoice, classchoice,adults,infants,children;
    String[] source={"DeLHI","Calicut","mumbai","Punjab","Rajasthan","sikkim","Uttrakhand","uttar pradesh","Manipur",
"Meghalaya","Mizoram","Nagaland","Odisha","bangalore","goa","chennai","hyderabad","mangalore","kochin","Thiruvananthapuram ","coimbatore","madurai",
              "Pondicherry","mysore"};
 String[] international={"London","Tokyo","Los angeles","Dubai","”Hong kong","shangai","singapore","Colorado","Malaysia","madrid"
     ,"washington","new York", "Oman","barbados","canada","jamaica","mexico","chicago","las vegas","chile ","Thailand","qatar",
     "france","australia"};
 
    Scanner in=new Scanner(System.in);
    GregorianCalendar gcalendar = new GregorianCalendar();
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    boolean[] seating = new boolean[200];
    
   public void airways()throws IOException
   {   
    System.out.println("***WELCOME TO AIRLINE SERVICES***");
     do{
         System.out.println("**************************");
         System.out.println("SELECT A SUITABLE ACTION TO BE PERFORMED***");
         System.out.println("1.Ticket Booking\n 2.Manage Booking\n 3.View Holiday Pakages 4.Travel stories \n5.quit\n");
         choice=Integer.parseInt(br.readLine());
         switch(choice)
         {
          case 1:book_Ticket();
                  break;
          case 2:manage_booking();
                 break;
          case 3:
                 String[] holiday={"Bangalore","Goa","Delhi","Chennai","Hyderabad","Kochin","Calicut",
                     "Mumbai","Singapore","Thailand","Dubai"};
                 System.out.println("Packages available");
                 System.out.println("1.Bangalore \t 2.Goa\t 3.Delhi\t4.Chennai\n5.Hyderabad");
                 System.out.println("\n6.Kochin\t7.Calicut\n 8.Mumbai\t9.Singapore\t10.Thailand\t11.Dubai");
                 System.out.println("Select a package");
                 int p=Integer.parseInt(br.readLine()); 
                 
        HolidayPackage delhiHolidayPackage = new HolidayPackage(holiday[p-1]);
        delhiHolidayPackage.viewPackage();
        System.out.println("Do you want to confirm booking\n");
        String ch=br.readLine();
        delhiHolidayPackage.confirmPackage(ch);    
                  break;
        case 4:travel_stories();
        break;
      
        case 5:System.out.println("Quit\n");
                  break;        
          default:System.out.println("Please enter a valid option\n");
                  break;

         }
       }while(choice!=4);
        
    }

    
     void date_check(String from,String to,int tripchoice)throws IOException
      {
        int flag,flag1;
        String day="",month="",year="",dates="";
    
        do{
             flag=0;
         if(tripchoice==1)
        {System.out.println("Departure date:(dd-mm-yy)");
             d_date=br.readLine();
             dates=d_date;
            }
        else if(tripchoice==2)
        {System.out.println("Return date:(dd-mm-yy)");
         r_date=br.readLine();
         dates=d_date;
        }
        
         int  i=0;
        while(dates.charAt(i)!='-')
           {day+=d_date.charAt(i);
               i++;
            }
           i++;
            while(dates.charAt(i)!='-')
           {month+=d_date.charAt(i);
               i++;
          }
            i++;
           for(;i<dates.length();i++)
           year+=dates.charAt(i);
           day1=Integer.parseInt(day);
           month1=Integer.parseInt(month);
           year1=Integer.parseInt(year);
          if(month1==0||day1==0||year1==0)
           flag=1; 
         if(month1==2&&(year1%4==0))
         {if(day1>29)
          flag=1;
            }    
         if(month1==4||month1==6||month1==9||month1==11)
         {if(day1>30)
           flag=1;
        }
        if(year1<17||year1>19)
          flag=1;
        //if(month1<gcalendar.get(Calendar.MONTH)&&month1<gcalendar.get(Calendar.YEAR%100))
         //flag=1;
         if(month1>12)
         flag=1;
         if(day1>31)
        flag=1;
       
        if(flag==1)
          System.out.println("Please enter a valid date\n");
        }while(flag==1);
   
    }
   
    

   void book_Ticket()throws IOException
    {
          int flag=0,flag1=0,x_class,count=0;
          String day="",month="",year="";
          System.out.println("****Welcome to ticket booking*****\n");
          System.out.println("would you like a 1.one way trip\n 2.round trip\n3.open-dated ticket\n");
         tripchoice=Integer.parseInt(br.readLine());
           do{
        flag=0;flag1=0;
        System.out.print("FROM:");
          from=br.readLine();
          System.out.print("TO:");
          to=br.readLine();
               
            for(int i=0;i<=23;i++)      // validity of from n to palces
         {
          if(source[i].equalsIgnoreCase(from)||international[i].equalsIgnoreCase(from))
           flag++;
          if(source[i].equalsIgnoreCase(to) ||international[i].equalsIgnoreCase(to))
          flag1++;
         }
         if(flag!=1)
         System.out.println("city name for 'from'  not found\n Please enter a valid name\n");
         if(flag1!=1)
         System.out.println("city name for 'to'  not found\n Please enter a valid name\n");
        }while(flag!=1||flag1!=1);
 
 
         if(tripchoice==1)
        {
       
          
          date_check(from,to,tripchoice);

    }
    if(tripchoice==2)
     {  
          date_check(from,to,1);
          date_check(from,to,tripchoice);

         
    }
    
  
     
//DISPLAYING OF FLIGHTS AVAILABLE



//passenger details


System.out.println("enter passenger details*** \n");



System.out.println("Number of adults:");
 adults=in.nextInt();

System.out.println("Number of children:");
 children=in.nextInt();

System.out.println("Number of infants:");
 infants=in.nextInt();
total_seats=adults+children+infants;
 while(infants>adults)
      {
      System.out.println("the number of infants cannot be greater than the adults");
     
      System.out.println("enter the number of infants\n");
     infants=in.nextInt();
    }
 
// seatavailability

     /* total of 200 seats including all classes*/
   int choice1;
   int choice2=0;

     
do{
  System.out.println("Please select type \n 1)First Class \n 2) Economy\n 3) Business class\n 4) premium economy\n ");
   classchoice = in.nextInt();
  choice1=search_Flights(from,to,day1,classchoice);
     for(int i=0;i<total_seats;i++)
  {switch(classchoice)
  {
    case 1 :   firstclass();
               break;
    case 2:   economy();break;
    case 3:   business();break;
    case 4:   premium_economy();break;
    default:   classchoice=5;
              System.out.println("please enter a valid class\n");
        
        }
    }
    confirm_display(choice1,1);
    
   
    

    
    if(tripchoice==2)
     {
         System.out.println("FOR THE RETURN TRIP\n");
         System.out.println("Please select type \n 1)First Class \n 2) Economy\n 3) Business class\n 4) premium economy\n ");
   classchoice = in.nextInt();
   int i=0;
   int day1;
   
    while(r_date.charAt(i)!='-')
           {day+=r_date.charAt(i);
               i++;
            }
      day1=Integer.parseInt(day);   
         choice2=search_Flights(to,from,day1,classchoice); 
   
   for(i=0;i<total_seats;i++)
  {switch(classchoice)
  {
    case 1 :   firstclass();
               break;
    case 2:   economy();break;
    case 3:   business();break;
    case 4:   premium_economy();break;
    default:   classchoice=5;
              System.out.println("please enter a valid class\n");
        
        }
    }
    confirm_display(choice2,2);
}
} while(classchoice==5);
 

     do{
        flag=0;
System.out.println("Do you want to confirm the booking");
     System.out.println("1)YES\n2)NO\n");
     int a=Integer.parseInt(br.readLine());
String card_no,holder_name,cvv;
 
     if(a==1)
       {   
          System.out.println("PAYEMENT THROUGH CREDIT/DEBIT CARD\n");
flag1=1;
int flag2=1;
while(flag1==1)
{
                  System.out.println("CREDIT CARD NO.:");
 
             card_no=br.readLine();
            if(card_no.length()!=16)

{System.out.println("INVALID CREDIT NUMBER\n");
flag1=1;
}
else
flag1=0;
}
 System.out.println("CARD-HOLDER NAME:");
holder_name=br.readLine();
flag2=1;
while(flag2==1)
{
                  
 System.out.println(" CVV:");
 
            cvv=br.readLine();
if(cvv.length()!=4)
{System.out.println("INVALID CVV\n");
flag2=1;
}
else
flag2=0;
}
 
 
 System.out.println("Rs."+Grand_total+"has been deducted from your account");
 
 
 

         System.out.println("******* BOOKING CONFIRMED FOR "+total_seats+" passengers *******");
         
         if(tripchoice==1||tripchoice==2)
        { for(int i=0;i<total_seats;i++)
        {   System.out.println("Enter the name of passenger "+(i+1));
            name[i]=br.readLine();
           
           ticket_viewing(choice1,name[i],i);
          
        }    }
                
    if(tripchoice==2)
    { System.out.println("RETURN TICKETS");
    for(int i=0;i<total_seats;i++)
        {  
           ticket_viewing(choice2,name[i],i);
          
    }
}
}
    else if(a==2)
    {
        System.out.println("1)Search another flight\n2)Back to home\n"); 
       int x=Integer.parseInt(br.readLine());
        if(x==1)
        { flag=1;
                
         }   
        if(x==2)
        airways();
       else 
        return;
   }
}while(flag==1);
    

}
   void firstclass() // assign a first class seat
    { int count = 1;
        if(tripchoice==2)
        { count=20;
        }
            
           
           
     for ( ; count <= 50; count++ )
        {
           if ( seating[count] == false )  // if false seat is empty or available
           {         
            seating[count] = true;  // assign seat
            System.out.println("First Class. Seat#"+count+"alloted\n");
            seat[c++]=count;
            break;
            }
       else
      if ( seating[50] == true ) // If seating[50] is true then first class is fully alloted
         {
          if ((seating[200] ==true)&&(seating[150]==true)&&(seating[100]==true)&&(seating[50]==true)) 
// If true whole flight is alloted
          {
       System.out.println("Sorry, flight fully alloted. Next flight is in 3 hours.");
         }
        else 
 {
  System.out.println("First Class is fully alloted. Would you like 1. Economy\n   2.business class  3.premimum economy");			 
   int choice = in.nextInt();
   switch(choice)
   {
    case 1: economy();break;
    case 2: business();break;
    case 3: premium_economy();break;
    default: System.out.println("next flight in 3 hours\nTHANKYOU\n.");
    }
       }
        }  
                              
       }
       }

     void economy() 
   
        {
        for ( int count =51; count <= 100; count++ )
        {
         if ( seating[count] == false )  // if false seat is empty or available
          {   
           seating[count] = true;  // assign seat
           System.out.println("Economy  Seat#"+count+"alloted\n");
           seat[c++]=count;
           break;
          }
       else
      if ( seating[100] == true ) // If seating[100] is true then economy class is fully alloted
       {
      if ((seating[200] ==true)&&(seating[150]==true)&&(seating[100]==true)&&(seating[50]==true)) 
// If true whole flight is alloted
       {
          System.out.println("Sorry, flight fully alloted. Next flight is in 3 hours\n.");
        }                                          
                                              
        else 
         {
         System.out.println("Economy is fully alloted. Would you like 1. First class or 2.business class 3.premium ecomony\n");			 
         int choice = in.nextInt();
          switch(choice)
         {
          case 1: firstclass();break;
          case 2: business();break;
	  case 3: premium_economy();break;
          default: System.out.println("next flight in 3 hours\nTHANKYOU\n.");
         }
    }
   }  
 }
 }




void business() 
 {
  for ( int count =101; count <= 150; count++ )
        {
         if ( seating[count] == false )  // if false seat is empty or available
         {
           seating[count] = true;  // assign seat
          System.out.println("Business Seat#"+count+"  alloted\n");
          seat[c++]=count;
            break;
            }
            else
           if ( seating[150] == true ) // If seating[150] is true then business class is fully alloted
           {
           if ((seating[200] ==true)&&(seating[150]==true)&&(seating[100]==true)&&(seating[50]==true)) 
// If true whole flight is alloted
	 {
           System.out.println("Sorry, flight fully alloted. Next flight is in 3 hours.");
            }
         else
         {
             System.out.println("Business class is fully alloted. Would you like 1. First class or 2.Economy \n or 3.premium economy?\n");			 
            int choice = in.nextInt();
              switch(choice)
             { case 1: firstclass();break;
                case 2: economy();break;
	         case 3: premium_economy();break;
                default: System.out.println("next flight in 3 hours\nTHANKYOU\n.");
               }
              }
            }  
                              
        }
       }

void premium_economy()
    {
        for ( int count = 151; count < 200; count++ )
        {
           if ( seating[count] == false )  // if false seat is empty or available
            {
             seating[count] = true;  // assign seat
              System.out.println("Premium economy Seat#"+count+" alloted\n");
              seat[c++]=count;
               break;
               }
            else
             if ( seating[199] == true ) // If seating[200] is true then p.e is fully alloted
                                      {
            if ((seating[199] ==true)&&(seating[150]==true)&&(seating[100]==true)&&(seating[50]==true)) 
// If true whole flight is alloted
             {
              System.out.println("Sorry, flight fully alloted. Next flight is in 3 hours.");
                                                
             }
             else 
            { System.out.println("First Class is fully alloted. Would you like 1. Economy 2.business class  3.first class ?");			 
                int choice = in.nextInt();
               switch(choice)
                {
               case 1: economy();break;
                case 2: business();break;
                 case 3: firstclass();break;
               default: System.out.println("next flight in 3 hours\nTHANKYOU\n.");
                                                       }
                                           }
                                   }  
              
       }      }
                  
  
    
       int search_Flights(String from,String to,int day1,int classchoice)throws IOException
         
         { int flag=-1;
          System.out.println("******Searching flights******\n");
          String[] s={"bangalore","goa","chennai","hyderabad","mangalore","kochin","Thiruvananthapuram ","coimbatore","madurai",
              "Pondicherry","mysore"};
           int classrate=0; 
          
           if(classchoice==2)
             classrate=700;
           if(classchoice==3)
          classrate=950;
          if(classchoice==4)
          classrate=1000;  
          for(String t:s)
            {
                if(t.equalsIgnoreCase(from))
              { 
                for(String r:s)  
                 if(r.equalsIgnoreCase(to))
                  flag=1;
               
            }   }
              if(flag==1)
            
            {   
                int[] rates={2250,2300,2400,2130,2730,2600,2900,2400,2780,2900};
                 
                if(day1%2==0&&day1%3!=0)
                {  
                    String[] airways1={"Spicejet","JetAirways","Indigo","JetAirways","Spicejet","Air India","Spicejet",
                    "Indigo","Spicejet","Jet airways"};
                    String[] dept_time1={"07:30","09:45","12:10","16:50","18:30","21:30","21:30","22:30","22:40","23:30"};
                    String[] reach_time1={"08:35","10:20","13:50","17:50","19:15","22:20","22:40","23:40","23:40","00:40"};
                    for(int i=0;i<6;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
                  System.out.println("**************Available flights:********\n");
                  System.out.println("1)Spicejet: 07:30 ----> 08:35 \t Price/head="+(rates[0]+classrate));
                  System.out.println("   Amenities:Food\n");
                  System.out.println("2)JetAirways: 09:45 --->10:20 \t Price/head="+(rates[1]+classrate) );  
                  System.out.println("   Amenities:Food\n");
 
                 System.out.println("3)Indigo: 12:10  -----> 13:50 \t Price/head="+(rates[2]+classrate));  
                 System.out.println("   Amenities:Food\n");
 
                  System.out.println("4)Jet Airways: 16:50 --->17:40\t Price/head="+(rates[3]+classrate)); 
                 System.out.println("   Amenities:none \n");
 
                  System.out.println("5)Spicejet: 18:30 ----> 19:15\t Price/head="+(rates[4]+classrate));  
                   System.out.println("   Amenities:Food\n");
 
                  System.out.println("6)Air India: 21:30 ----> 22:20\t Price/head="+(rates[5]+classrate));
      System.out.println("   Amenities:Food\n");
 
                  System.out.println("7)Spicejet: 21:30 ----> 22:40\t Price/head="+(rates[6]+classrate));
 System.out.println("   Amenities:Food,,wifi\n");
 
                  System.out.println("8)Indigo: 22:30 ---->23:40\t Price/head="+(rates[7]+classrate));
System.out.println("   Amenities:Food\n");
 
                  System.out.println("9)Spicejet:22:40 ----> 23:40\t Price/head="+(rates[8]+classrate));
System.out.println("   Amenities:none\n");
 
                  System.out.println("10)Jet Airways:23:30 ----> 00:40\t Price/head="+(rates[9]+classrate));
System.out.println("   Amenities:Food\n");
 
                  
                }
                 
                else 
                 {
                     String[] airways1={"JetAirways","Spicejet","Air India","Indigo","Spicejet","JetAirways","Spicejet",
                      "Indigo","Spicejet","Jet airways"};
                    String[] dept_time1={"08:45","11:30","13:25","16:10","18:30","20:50"," 21:30 ","22:30","22:40","23:30"};
                    String[] reach_time1={"09:35","12:35","14:20","17:10","19:15","21:40","22:40","23:40","23:40","00:40"};
                    for(int i=0;i<10;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
                  System.out.println("******Available flights:********\n");
                  System.out.println("1)Jet Airways: 08:45 ----> 9:35\t Price/head="+(rates[0]+classrate));  
System.out.println("   Amenities:Food\n");
 
                  System.out.println("2)Spicejet: 11:30 ----> 12:35\t Price/head="+(rates[1]+classrate));
System.out.println("   Amenities:Food\n");
 
                  System.out.println("3)Air India: 13:25 ----> 14:20 \t Price/head="+(rates[2]+classrate));    
System.out.println("   Amenities:Food\n");
 
                  System.out.println("4)Indigo: 16:10 ----> 17:10 \t Price/head="+(rates[3]+classrate));  
System.out.println("   Amenities:none\n");
 
                  System.out.println("5)Spicejet: 18:30 ----> 19:15 \t Price/head="+(rates[4]+classrate));  
System.out.println("   Amenities:none\n");
 
                  System.out.println("6)Jet Airways: 20:50 ----> 21:40 \t Price/head="+(rates[5]+classrate));
System.out.println("   Amenities:Food\n");
 
                  System.out.println("7)Spicejet: 21:30 ----> 22:40\t Price/head="+(rates[6]+classrate));
System.out.println("   Amenities:Food,wifi\n");
 
                  System.out.println("8)Indigo: 22:30 ---->23:40\t Price/head="+(rates[7]+classrate));
System.out.println("   Amenities:Food\n");
 
                  System.out.println("9)Spicejet:22:40 ----> 23:40\t Price/head="+(rates[8]+classrate));
System.out.println("   Amenities:Food\n");
 
                  System.out.println("10)Jet Airways:23:30 ----> 00:40\t Price/head="+(rates[9]+classrate));
System.out.println("   Amenities:Food\n");
 
                   
                  
                }
                for (int i=0;i<10;i++)
                    RATE[i]=rates[i]+classrate;  
             
            }
            
            String[] n={"DeLHI","Calicut","mumbai","Punjab","Rajasthan","sikkim","Uttrakhand","uttar pradesh","Manipur",
"Meghalaya","Mizoram","Nagaland","Odisha"};
            for(String t:n)
            {
              if(t.equalsIgnoreCase(from))
              { 
                for(String r:n)  
                   if(r.equalsIgnoreCase(to))
                      flag=2; 
                    }
                }
           
                    if(flag==2)
            { 
                int[] rates={2750,2220,2670,2620,2340,2780,2650,2250,2300,2400};
                if(day1%2==0&&day1%3!=0)
                {
                    String[] airways1={"Spicejet","Indigo","Go Air","Vistara","Air India","Spicejet","Jet airways","Go air","Jet airways"
                    ,"Spice jet"};
                String[] dept_time1={"00:50","07:10","07:10","08:45","09:30","12:35","15:45","18:50","21:50","21:30"};
                String[] reach_time1={"01:45","08:25","08:20","09:55","10:40","13:35","16:55","19:55","22:55","22:40"};
                  for(int i=0;i<10;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
                    System.out.println("**************Available flights:********\n");
                    System.out.println("1)Spicejet: 00:50 ----> 01:45 \t Price/head="+(rates[0]+classrate));  
System.out.println("   Amenities:Food\n");
 
                    System.out.println("2)Indigo: 07:10 ----> 08:25 \t Price/head="+(rates[1]+classrate)); 
System.out.println("   Amenities:Food\n");
 
                    System.out.println("3)Go Air: 07:10 ----> 08:20 \t Price/head="+(rates[2]+classrate));
System.out.println("   Amenities:Food\n");
 
                    System.out.println("4)Vistara: 08:45 ----> 09:55 \t Price/head="+(rates[3]+classrate)); 
System.out.println("   Amenities:Food\n");
 
                    System.out.println("5)Air India: 09:30 ----> 10:40 \t Price/head="+(rates[4]+classrate)); 
System.out.println("   Amenities:Food\n");
 
                    System.out.println("6)Spicejet: 12:35 ----> 13:35 \t Price/head="+(rates[5]+classrate));
System.out.println("   Amenities:Food\n");
 
                    System.out.println("7)Jet Airways: 15:45 ----> 16:55 \t Price/head="+(rates[6]+classrate));
System.out.println("   Amenities:Food\n");
  
                    System.out.println("8)Go Air: 18:50 ----> 19:55 \t Price/head="+(rates[7]+classrate)); 
System.out.println("   Amenities:Food\n");
                    System.out.println("9)Jet Airways: 21:50 ----> 22:55 \t Price/head="+(rates[8]+classrate)); 
System.out.println("   Amenities:Food\n");
 
                     System.out.println("10)Spicejet: 21:30 ----> 22:40\t Price/head="+(rates[9]+classrate));
System.out.println("   Amenities:Food\n");
 
                   
                   
                }
                else 
                 
                { String[] airways1={"Indigo","Go air","Vistara","Spice jet","JetAirways","Spicejet","Jet airways",
                    "Go air","Spice jet","Spice jet"};
                 String[] dept_time1={"01:20","06:40","07:10","09:30","12:45","15:35","19:50","21:10","21:30","22:30"};
                  String[] reach_time1={"02:30","07:55","08:20","10:40","13:55","16:55","20:55","22:20","22:40","23:20"};
                  for(int i=0;i<10;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
                    System.out.println("**************Available flights:********\n");
                    System.out.println("1)Indigo: 01:20 ----> 02:30\t Price/head="+(rates[0]+classrate)); 
System.out.println("   Amenities:Food\n");
 
                    System.out.println("2)Go air: 06:40 ----> 07:55\t Price/head="+(rates[1]+classrate)); 
System.out.println("   Amenities:Food\n");
 
                    System.out.println("3)Vistara: 07:10 ----> 08:20\t Price/head="+(rates[2]+classrate));
System.out.println("   Amenities:Food\n");
                    System.out.println("4)Spicejet: 09:30 ----> 10:40\t Price/head="+(rates[3]+classrate));
System.out.println("   Amenities:Food\n");
 
                    System.out.println("5)Jet Airways: 12:45 ----> 13:55 \t Price/head="+(rates[4]+classrate));
System.out.println("   Amenities:Food\n");
 
                    System.out.println("6)Spicejet: 15:35 ----> 16:55\t Price/head="+(rates[5]+classrate));
System.out.println("   Amenities:Food\n");
 
                    System.out.println("7)Jet Airways: 19:50 ----> 20:55\t Price/head="+(rates[6]+classrate)); 
System.out.println("   Amenities:Food\n");
 
                    System.out.println("8)Go Air: 21:10 ----> 22:20 \t Price/head="+(rates[7]+classrate));
System.out.println("   Amenities:Food\n");
 
                    System.out.println("9)Spicejet: 21:30 ----> 22:40\t Price/head="+(rates[8]+classrate));
System.out.println("   Amenities:Food\n");
 
                     System.out.println("10)Spicejet: 22:30 ----> 23:20\t Price/head="+(rates[9]+classrate));
System.out.println("   Amenities:Food\n");
 
                }
                for (int i=0;i<10;i++)
                    RATE[i]=rates[i]+classrate;  
            }
               
        
               
        for(String t:source)
            {
              if(t.equalsIgnoreCase(from))
              { 
                for(String r:source)  
                   if(r.equalsIgnoreCase(to))
                      flag=0; 
                    }
                }
           
             if(flag==0)
            {  int[] rates={6000,6500,6700,6620,5980,6000,6400,6400,6700,6500};
                if(day1%2==0&&day1%3!=0)
                {  String[] airways1={"Go air","Indigo","Vistara","Spice jet","JetAirways","Spicejet","Jet airways","Go air","Spice jet",
                  "Spice jet"};
                 String[] dept_time1={"02:40","05:40","07:10","10:30","12:45","15:35","19:50","21:10","21:30","21:30"};
                  String[] reach_time1={"04:30","07:55","09:20","12:20","14:55","17:55","21:55","22:20","23:40","22:40"};
                  for(int i=0;i<10;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
                    System.out.println("**************Available flights:********\n");
                    System.out.println("1)Go air: 02:40 ----> 04:30\t Price/head="+(rates[0]+classrate)); 
System.out.println("   Amenities:Food,wifi,video- on demand\n");
 
                    System.out.println("2)Indigo: 05:40 ----> 07:55\t Price/head="+(rates[1]+classrate)); 
System.out.println("   Amenities:Food,wifi,video- on demand\n");
 
                    System.out.println("3)Vistara: 07:10 ----> 09:20\t Price/head="+(rates[2]+classrate));
System.out.println("   Amenities:Food,wifi,video- on demand\n");
 
                    System.out.println("4)Spicejet: 10:30 ----> 12:20\t Price/head="+(rates[3]+classrate));
System.out.println("   Amenities:Food,wifi n");
 
                    System.out.println("5)Jet Airways: 12:45 ----> 14:55 \t Price/head="+(rates[4]+classrate));
System.out.println("   Amenities:Food,wifi,video- on demand\n");
 
                    System.out.println("6)Spicejet: 15:35 ----> 17:55\t Price/head="+(rates[5]+classrate));
System.out.println("   Amenities:Food,wifi,video- on demand\n");
 
                    System.out.println("7)Jet Airways: 19:50 ----> 21:55\t Price/head="+(rates[6]+classrate)); 
System.out.println("   Amenities:Food,video- on demand\n");
 
                    System.out.println("8)Go Air: 19:10 ----> 22:20 \t Price/head="+(rates[7]+classrate));
System.out.println("   Amenities:Food,wifi,video- on demand\n");
 
                    System.out.println("9)Spicejet: 21:30 ----> 23:40\t Price/head="+(rates[8]+classrate)); 
System.out.println("   Amenities:Food,wifi \n");
 
                    System.out.println("10)Spicejet: 21:30 ----> 22:40\t Price/head="+(rates[9]+classrate));
System.out.println("   Amenities:Food,,video- on demand\n");
 
                    
                }
                else 
                 {
                   System.out.println("**************Available flights:********\n");
                   String[] airways1={"Indigo","Go air","Vistara","Spice jet","JetAirways","Spicejet","Jet airways",
                    "Go air","Spice jet","Spice jet"};
                 String[] dept_time1={"01:20","06:40","07:10","09:30","12:45","15:35","19:50","21:10","21:30","22:30"};
                  String[] reach_time1={"02:30","07:55","08:20","10:40","13:55","16:55","20:55","22:20","22:40","23:20"};
                  for(int i=0;i<10;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
                     System.out.println("**************Available flights:********\n");
                    System.out.println("1)Indigo: 01:20 ----> 02:30\t Price/head="+(rates[0]+classrate)); 
                    System.out.println("   Amenities:Food,wifi,video- on demand\n");
                    System.out.println("2)Go air: 06:40 ----> 07:55\t Price/head="+(rates[1]+classrate)); 
                    System.out.println("   Amenities:Food,wifi\n");
                    System.out.println("3)Vistara: 07:10 ----> 08:20\t Price/head="+(rates[2]+classrate));
                    System.out.println("   Amenities:Food,wifi,video- on demand\n");
                    System.out.println("4)Spicejet: 09:30 ----> 10:40\t Price/head="+(rates[3]+classrate));
                    System.out.println("   Amenities:Food,video- on demand\n");
                    System.out.println("5)Jet Airways: 12:45 ----> 13:55 \t Price/head="+(rates[4]+classrate));
                    System.out.println("   Amenities:Food,wifi,video- on demand\n");
                    System.out.println("6)Spicejet: 15:35 ----> 16:55\t Price/head="+(rates[5]+classrate));
                    System.out.println("   Amenities:Food,wifi,video- on demand\n");
                    System.out.println("7)Jet Airways: 19:50 ----> 20:55\t Price/head="+(rates[6]+classrate));
                    System.out.println("   Amenities:Food,wifi,video- on demand\n");
                    System.out.println("8)Go Air: 21:10 ----> 22:20 \t Price/head="+(rates[7]+classrate));
                    System.out.println("   Amenities:Food,wifi,video- on demand\n");
                    System.out.println("9)Spicejet: 21:30 ----> 22:40\t Price/head="+(rates[8]+classrate));
                    System.out.println("   Amenities:Food,wifi,video- on demand\n");
                     System.out.println("10)Spicejet: 22:30 ----> 23:20\t Price/head="+(rates[9]+classrate));
                     System.out.println("   Amenities:Food,wifi\n");
                }
                for (int i=0;i<10;i++)
                    RATE[i]=rates[i]+classrate;  
            }
                
                 for(String t:international)
            {
                if(t.equalsIgnoreCase(from))
              { 
                for(String r:international)  
                 if(r.equalsIgnoreCase(to))
                  flag=4;
               
            } 
        }
 if(flag==4)
            
            {   
                int[] rates={6250,7400,9400,10530,10930,11050,11700,12400,13456,13900};
                 
                if(day1%2==0&&day1%3!=0)
                {  
                    String[] airways1={"AirOne","QatarAirways","TurkishAirlines","JetAirways","AirFrance","Emirates","QatarAirways",
                    "Lufthansa","SriLankanAirlines","BritishAirways"};
                    String[] dept_time1={"07:30","09:45","12:10","16:50","18:30","21:30","21:30","22:30","22:40","23:30"};
                    String[] reach_time1={"12:35","14:20","17:50","20:50","23:15","02:20","01:40","03:40","04:40","05:40"};
                    for(int i=0;i<10;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
                    System.out.println("**************Available flights:********\n");
                  System.out.println("1) AirOne: 07:30 ----> 12:35 \t Price/head="+(rates[0]+classrate));
                  System.out.println("Amenities: Food ,Wifi,Entertainment\n");
               
 
                  System.out.println("3): Turkish Airlines 12:10  -----> 17:50 \t Price/head="+(rates[2]+classrate));
                                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
  
                  System.out.println("4)BritishAirways: 16:50 --->20:40\t Price/head="+(rates[3]+classrate)); 
                                          System.out.println("Amenities: Food ,Wifi,Entertainment\n");;
 
                  System.out.println("5): AirFrance 18:30 ----> 23:15\t Price/head="+(rates[4]+classrate));  
                  System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                  System.out.println("6)Emirates: 21:30 ----> 02:20\t Price/head="+(rates[5]+classrate));
                        System.out.println("Amenities: Food ,Wifi,Entertainment\n");
 
                  System.out.println("7)QatarAirways: 21:30 ----> 01:40\t Price/head="+(rates[6]+classrate));
       System.out.println("Amenities: Food ,Wifi,Entertainment\n");
 
                  System.out.println("8)Lufthansa: 22:30 ---->03:40\t Price/head="+(rates[7]+classrate));
                        System.out.println("Amenities: Food ,Wifi,Entertainment\n");
 
                  System.out.println("9)SriLankanAirlines:22:40 ----> 04:40\t Price/head="+(rates[8]+classrate));
                  System.out.println("Amenities: Food ,Wifi,Entertainment\n");
 
                  System.out.println("10)British Airways:23:30 ----> 05:40\t Price/head="+(rates[9]+classrate));
                       System.out.println("Amenities: Food ,Wifi,Entertainment\n");
 
                  
                }
                 
                
                  
                else 
 
 
                 {
                     String[] airways1={"Lufthansa","SrilankanAirways","Emirates","AirOne","AirFrance","BritishAirways","QatarAirways",
                      "AirCanada","SrilankanAirways","BritishAirways"};
                    String[] dept_time1={"08:45","11:30","13:25","16:10","18:30","20:50"," 21:30 ","22:30","22:40","23:30"};
                    String[] reach_time1={"12:35","16:35","19:20","21:10","23:15","00:40","02:40","03:40","05:40","05:40"};
                    for(int i=0;i<10;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
                  System.out.println("******Available flights:********\n");
                  System.out.println("1)Lufthansa: 08:45 ----> 12:35\t Price/head="+(rates[0]+classrate)); 
                                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                  System.out.println("2SrilankanAirways: 11:30 ----> 16:35\t Price/head="+(rates[1]+classrate));
                                   System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                      System.out.println("3)Emirates: 13:25 ----> 19:20 \t Price/head="+(rates[2]+classrate));    
                  System.out.println("4)AirOne: 16:10 ----> 21:10 \t Price/head="+(rates[3]+classrate));  
                                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                  System.out.println("5)AirFrance: 18:30 ----> 23:15 \t Price/head="+(rates[4]+classrate));  
                                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                  System.out.println("6)BritishAirways: 20:50 ----> 00:40 \t Price/head="+(rates[5]+classrate));
                                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                  System.out.println("7)QatarAirways: 21:30 ----> 02:40\t Price/head="+(rates[6]+classrate));
                                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                  System.out.println("8)IAirCanada: 22:30 ---->03:40\t Price/head="+(rates[7]+classrate));
                                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                  System.out.println("9)SrilankanAirways:22:40 ----> 05:40\t Price/head="+(rates[8]+classrate));
                                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                  System.out.println("10)BritishAirways:23:30 ----> 05:40\t Price/head="+(rates[9]+classrate));
                                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                   
                  
                }
                for (int i=0;i<10;i++)
                    RATE[i]=rates[i]+classrate;  }
               
              if(flag==-1)
            {  int[] rates={10000,12000,16700,17220,18980,20000,22400,23400,25700,27500};
                if(day1%2==0&&day1%3!=0)
                {  String[] airways1={"Goair","AirIndia","Kingfisher","SrilankanAirways","JetAirways","SrilankanAirways","Jet airways","Go air","Kingfisher",
                  "AirIndia"};
                 String[] dept_time1={"02:40","05:40","07:10","10:30","12:45","15:35","19:50","21:10","21:30","21:30"};
                  String[] reach_time1={"12:30","16:55","08:20","19:20","23:55","01:55","03:55","06:20","08:40","09:40"};
                   for(int i=0;i<10;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
                    System.out.println("**************Available flights:********\n");
                                      System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("1)Goair: 02:40 ----> 07:30 Mumbai \n 08:30 Mumbai--à12:30\n Price/head="+(rates[0]+classrate));
                                      System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("2)Air India: 05:40 ----> 10:55 Mumbai \n 12:00 Mumbai --à 16:55\n Price/head="+(rates[1]+classrate));
                    System.out.println("Amenities: Food ,Wifi,Entertainment\n"); 
                    System.out.println("3)Kingfisher: 07:10 ----> 12:20 Mumbai\n 13.30 Mumbai --à 08:20\n Price/head="+(rates[2]+classrate));
                     System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("4)SrilankanAirways: 10:30 ----> 15:20 Mumbai \n 15:20 Mumbai --à 19:20\n Price/head="+(rates[3]+classrate));
                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("5)JetAirways: 12:45 ----> 17:55 Mumbai \n 19:00 Mumbai-à23:55\n Price/head="+(rates[4]+classrate));
                     System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("6)SrilankanAirways: 15:35 ----> 20:55 Mumbai \n 22:00 Mumbai--à01.55\n Price/head="+(rates[5]+classrate));
                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("7)JetAirways: 19:50 ----> 00:55 Mumbai \n 02:00 Mumbai--à03:55\n Price/head="+(rates[6]+classrate)); 
                     System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("8)Go air: 21:10 ----> 00:20Mumbai \n 01:30 Mumbai --à 06:20\n Price/head="+(rates[7]+classrate));
                    
                     System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("9) Kingfisher: 21:30 ----> 02:40 Mumbai\n 03:40 Mumbai--à 08:40\n Price/head="+(rates[8]+classrate)); 
                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("10)AirIndia: 21:30 ----> 2:40 Mumbai\n 4:40 Mumbai--à09:40\n Price/head="+(rates[9]+classrate));
                     System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                }
                else 
                 {
                       String[] airways1={"AirIndia","GoAir","SrilankanAirways","JetAirways","SrilankanAirways","Jet airways",
                           "Go air","AirIndia",
                  "AirIndia","JetAirways"};
 
 
                         String[] dept_time1={"03:40","04:40","06:20","10:30","13:55","14:35","20:50","22:50","23:30","23:50"};
                  String[] reach_time1={"15:30","19:55","20:20","21:20","23:55","03:55","06:55","09:50","11:40","12:40"};
                  for(int i=0;i<10;i++)
                    { airways[i]=airways1[i];
                      dept_time[i]=dept_time1[i];
                      reach_time[i]=reach_time1[i];
                    }
 
 
 
                    System.out.println("**************Available flights:********\n");
                    System.out.println("1) AirIndia: 03:40 ----> 08:30 Mumbai \n 09:30 Mumbai--à15:30\n Price/head="+(rates[0]+classrate)); 
                     System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("2): Goair :04:40 ----> 09:55 Mumbai \n 11:00 Mumbai --à 19:55\n Price/head="+(rates[1]+classrate)); 
                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("3)SrilankAirways: 06:20 ----> 11:20 Mumbai\n 12.30 Mumbai --à 20:20\n Price/head="+(rates[2]+classrate));
                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("4) Jet Airways: 10:30 ----> 02:20 Mumbai \n 03:20 Mumbai --à 21:20\n Price/head="+(rates[3]+classrate));
                     System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("5) Srilankan Airways: 13:55 ----> 18:55 Mumbai \n 19:30 Mumbai-à23:55\n Price/head="+(rates[4]+classrate));
                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("6) Jet Airways: 14:35 ----> 21:55 Mumbai \n 22:40 Mumbai--à03.55\n Price/head="+(rates[5]+classrate));
                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("7) Go Air: 20:50 ----> 02:55 Mumbai \n 03:00 Mumbai--à06:55\n Price/head="+(rates[6]+classrate)); 
                     System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("8) Air India: 22:50 ----> 02:20Mumbai \n 03:30 Mumbai --à 09:50\n Price/head="+(rates[7]+classrate));
                     System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("9 ) Air India 23:30 ----> 04:40 Mumbai\n 05:40 Mumbai--à 11:40\n Price/head="+(rates[8]+classrate)); 
                    System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                    System.out.println("10)JetAirways: 23:50 ----> 4:40 Mumbai\n 5:15 Mumbai--à12:40\n Price/head="+(rates[9]+classrate));
  System.out.println("Amenities: Food ,Wifi,Entertainment\n");
                }
            
            for (int i=0;i<10;i++)
                    RATE[i]=rates[i]+classrate;  
                }
            
             int choice1=0;
             while(choice1<=0||choice1>10)
             {System.out.println("Enter your choice\n");
             choice1=Integer.parseInt(br.readLine());
            }
            return  (choice1-1) ;
           }
           
           void confirm_display(int choice,int x)
    { 
     System.out.println("Confirmation of Booking:\n");
     System.out.println("Airline:"+airways[choice]);
     if(x==2)
     System.out.println("Departure date:"+r_date);
     else
     System.out.println("Departure date:"+d_date);
     System.out.println("Departure time:"+dept_time[choice]);
     System.out.println("Reaching time:"+reach_time[choice]);
  
     int  total_cost=RATE[choice]*total_seats;
       System.out.println("Total cost:"+total_cost);
   double Total1,Infant_dis=0;
   int Dis;
    if(day1%2==0&&day1%3!=0)
     {
Dis=15;
     Total1=(RATE[choice]-(0.15*RATE[choice]))*(adults+children);
     if(infants>0)
    Infant_dis=( RATE[choice]-(0.25*RATE[choice]))*(infants);
   Grand_total= Total1+ Infant_dis;
    
}
    else
 
     { Dis=20;
       System. out.println("rate"+RATE[choice]);  
     Total1= ( RATE[choice]-(0.20*RATE[choice]))*(adults+children);
     if(infants>0)
    Infant_dis= ( RATE[choice]-(0.30*RATE[choice]))*(infants);
   Grand_total= Total1+ Infant_dis;
   
}
System. out.println("Discount available for you:\n");
System. out.println("Travel discount:"+Dis+"%");
if(infants>0)
System. out.println("Infant discount:"+(Dis+10)+"%");
 System. out.println("Grand total:"+Grand_total);
 
 
 
     System.out.println("Seat nos.:");
     int c2=0;
     if(tripchoice==2)
       c2=c/2;
     for(int i=c2;i<c;i++)
        System.out.println(seat[i]);
     if(tripchoice==3)
   
           System.out.println("*****The ticket is valid for 6 months from the date of issue*****\n");
} 
           void manage_booking()throws IOException
           {
               int choice;
               if(ticket_used==null)
               {
                   System.out.println("NO TICKETS BOOKED\n");
                   return;
                }
               
                       
                System.out.println("1.Cancel ticket\n2.Modify the departure date\n");
               choice=Integer.parseInt(br.readLine());
                System.out.println("Enter your ticket no");
                String ticket_no=br.readLine();
                for(String r:ticket_used)
                   {


    //To view details of package
    


                       {
              if(choice==1)
               {
                    System.out.println("TICKET CANCELLED\n");
                    return;
                }
              else if(choice==2)
                 {   
                     
                     date_check(from,to,tripchoice);
                         int ch;              
                     do{
  System.out.println("Please select type \n 1)First Class \n 2) Economy\n 3) Business class\n 4) premium economy\n ");
   classchoice = in.nextInt();
   ch=search_Flights(from,to,day1,classchoice);
   for(int i=0;i<total_seats;i++)
  {switch(classchoice)
  {
    case 1 :   firstclass();
               break;
    case 2:   economy();break;
    case 3:   business();break;
    case 4:   premium_economy();break;
    default:   classchoice=5;
              System.out.println("please enter a valid class\n");
        
        }
    } } while(classchoice==5);
confirm_display(ch,1);
}
else
System.out.println("Ticket not found");

}
}
}
void ticket_viewing(int choice1,String name,int j)
      {  
     
    String[] flight_no={"1AO123","AQW16Q","IQW123","EW546F","98YOW","PLI2E","WTY99","OR3P5","FRE56","QAY51"};
    int[] gate={37,01,54,31,42,11,34,11,06,21};
    
      String[] ticket_nos={"BRYF64","48H3UHF","D48R","4RLJ438R","F3JUFf","FRHFU","47R43HF","FLJF8RN","F34U8FG","DOEFK3U",
         "RJF85F","FRHF5959","FJ8UF","FJF34F8"};
    String board_time="";String board_time1="";
    System.out.println("******************************************************************************");
    System.out.println("\t\t\t"+airways[choice1]+"\t");
    System.out.println("******************************************************************************");
    System.out.println("Ticket no.:"+ticket_nos[choice1]+"\t");
    ticket_used[choice1]=ticket_nos[choice1+j];
    System.out.println("Name of the passenger:"+name+"\t");
    System.out.println("From");
    System.out.println(from);
    System.out.println("Flight\t\tDate\t\tTime" );
    System.out.println(flight_no[choice1]+"\t\t"+d_date+"\t"+dept_time[choice1] );
    System.out.println("To");
    System.out.println(to);
    if(tripchoice==2)
            System.out.println("Ticket type : ROUND TICKET\n");
   if(tripchoice==3)
              System.out.println("Ticket type: OPEN TICKET\n");

    System.out.println("Seat no.");
    System.out.println(seat[j]);
    int i=0;
    for(  ; (dept_time[choice1].charAt(i))!=':';i++)
     {
         board_time+=dept_time[choice1].charAt(i);
         
        
        }
    i++;
    for(;i<(dept_time[choice1]).length();i++)
       {board_time1+=dept_time[choice1].charAt(i) ;
        }
    
     int b1=Integer.parseInt(board_time);   
      int b2=Integer.parseInt(board_time1); 
      int b=(b1*60)+b2-55;
      String board=(b/60)+":"+(b%60);
           
      
        
    System.out.println("Boarding time\t\tGate");
    System.out.println(board+"\t\t\t"+gate[choice1]);
    return;
}
 void travel_stories()
 {
    System.out.println("7 must visit international destinations\n");

System.out.println("********************************************\n\n\n");

 

 

System.out.println ("1. Thailand\n\n");

System.out.println ("Topping the charts is the world renowned destination – Thailand. Indulge in its beaches, mountains, culture and food in just the right kind of budget.\n\n

Air Tickets: The round trip flight tickets can cost fairly between INR 17000 – 20,000, if boarding from New Delhi or Mumbai. Taking a round trip from Kolkata could cost around INR 9000 approx \n\n.

Stay: Whether you are traveling in a group or solo, Thailand is full of budget staying options starting from as low as INR 573 per night per person. You can choose from a dormitory type accommodation, a hostel or even a decent budget hotel.\n\n

Places to Eat: Thailand is famous for its street food. A good budget meal can cost up to approximately INR 60.\n\n

Places To Visit: A combination of any 2-3 cities like Bangkok, Pattaya and coral islands, Ayutthaya, Chiang Mai is a good option to explore the culture of Thailand. Almost every city will be home to few of the many Ancient Buddha temples, floating market, elephant show and so on.\n\n

Suggested Duration: 6 Days and 5 Nights\n\n\n");

 
 
 
 
System.out.println (“2. Singapore\n\n”);

System.out.println (“Singapore is a country that celebrates colorful culture. A tiny yet modern country offers great bargains and is a wise way to spend money on a vacation.\n\n”);

Air Tickets: The round trip flight tickets can cost between INR 20,000 – 22,000 onwards if boarding from New Delhi or Mumbai or INR 11,000 – 15000 From Chennai or Kolkata.\n\n

Stay: Singapore offers accommodation options like the City Backpackers @ Kallang or Fernloft City Hostel which offer stay for as low as INR 600/ night. On the other hand a single room can start from INR 2000/ night in a decent budget hotel.\n\n

Places to Eat: Chinatown food centre, Maxwell food centre or any hawker center are the places where you can get a meal in less than INR 500 inclusive of main, drink, and dessert\n\n.

Places To Visit: Singapore is famous as a holiday destination either for its day excursions or Singapore cruises. Either ways don’t miss out on the Famous National Museum of Singapore or Orchard Road/ Dhoby Ghaut Shopping stretch. Must Visit include Underwater world, Dolphin Lagoon\n\n

Suggested Duration: 4 Days and 3 Nights\n\n

Travel Calculation: Approx. INR 42,000\n\n
Interesting Tips: Explore Singapore at night when it is beautifully light up with the iconic Marina Bay Sands hotel and Singapore flyer view.\n\n\n”);

System.out.println(“ 3. Viet Nam\n\n”);

System.out.println (“Shaped like the letter “S”, lying on the eastern part of Indo-Chinese peninsula is Viet Nam. In the country you will find timeless charm and a flavor of another Asian culture.\n\n

Air Tickets: The round trip flight tickets can cost INR 16,000 onwards when planned 4-6 months in advance.
Tip: Stay on a lookout for promotional offers from Air Asia.\n\n

Stay: Ho Chi Minh City is home to hostels like Suite Backpackers Inn, Eco backpackers hostel and so on which provide single bed in dormitory rooms starting from as low as INR 400 per night. While a decent hotel for a single room ranges from INR 700 onwards per night.\n\n

Places to Eat: Some of the must eat traditional Vietnamese food include Nem Raan or Cha Gio (Fried Spring rolls) and Cha Ca (Grilled minced fish). Eat at street stalls. Take note of places like Cha Ca Street and Nguyen Truong to street in Hanoi for popular yet budget meals.\n\n

Things to do: The best way to save time and money is to take a short Yacht or boat cruise in Vietnam besides obvious indulgences like local market tours, island tours and wildlife tours. Must Visit include Hanoi, Ha Long Bay, Nha Trang, Ho Chi Minh city.\n\n

Suggested Duration: 6 Days and 5 Nights\n\n

Travel Calculation: Approx. INR 40,000\n\n\n”);

 
 
 
 
 
System.out.println (“4. Sri Lanka\n\n

Famous for the best backpacking destination, Sri Lanka is home to landscapes and culture which is much like India. Visit to feel like home away from home with a change.\n\n

Air Tickets: The round trip flight tickets can cost\n\n

From Delhi: INR 20,000 onwards\n
From Chennai: INR 8000 onwards\n

Stay: Colombo Sea view hostel, Colombo city hostel and so on are dormitory style accommodations that starts for INR 600/night. Similarly in other places like Kandy, Bentota and so on, hotel rooms can range from INR 1000 onwards per night\n\n.

Places to Eat: Ceylon Tea Moments in Colombo is one of the top choices which offers a huge menu within the range of INR 100-500; A classic Sri Lankan meal of fish curry in local markets can cost you less than INR 100.\n\n

Places To Visit: The must visit cities include Colombo, Kandy, Nuwara Eliya and Bentota. Also visit world heritage sites like Temple of tooth Relic, boating or fishing on Lake Gregory, tea factory visits, Seetha Eliya garden and temple from famous Ramayana, turtle hatchery etc. Visit Odel, Majestic city etc for shopping.\n\n

Suggested Duration: 5 Days and 4 Night\n\n\n”);

System.out.println (“5. Nepal\n\n

An ideal holiday destination for all types of traveler, surrounded by lofty peaks and scenic landscapes lays Nepal. It is a beautiful country which is every traveler’s delight.\n\n

Air Tickets: The round trip flight tickets from New Delhi could cost approx. INR 9000 onwards. or you could also take a bus ride from Kolkata\n\n

Stay: Hostels in places like Kathmandu start from as low as 300/night per person while a budget hotel for two could cost INR 600/night at an average.\n\n

Places to Eat: OR2K a popular Israeli-run restaurant can be a budget saver in Kathmandu while Krishna’s kitchen in Pokhara can be another ideal dining choice.\n\n

Places To Visit: Must Visits include Nagarkot, Kathmandu, Bhaktapur, Pokhara while popular things to do: Devi falls, gorge of Seti river, visit to Bindabasini Temple, Old bazaar of Pokhara.\n\n

Suggested Duration: 7 Days and 6 Nights\n\n\n”);

System.out.println (“6. Bhutan\n\n

The scenic country also called as the ‘land of the Thunder Dragons’ or the ‘Druk Yul’, offers pristine untouched natural wonders.This year is full of long weekends and Bhutan is close by! Plan your trip to the Shangri La of Himalayas.\n\n

Air Tickets: Finding a direct flight to Bhutan according to your convenience might be not a good option. Instead catch a domestic flight to Bagdogra Airport which is the nearest airport to the Bhutan border. The round trip can cost INR 6000 onwards. Take a 5 hour bus journey ahead which could cost approx INR 1900.\n\n

Stay: A Cozy and decent guest house room for two is easily available from INR 500 onwards.\n\n

Places to Eat: A meal at Sonam Trophel Restaurant in Paro serves minimum of 7 dishes which can cost you approx. INR 480 enough to satisfy two people or 2 meals together.\n\n

Places To Visit: Must visits in Bhutan include Paro, Thimphu, Punakha, Haa Valley while top things to do are – Monasteries, temples, farm houses, visit to the National Memorial Chorten, Takin Zoo and Folk heritage Museum.\n\n

Suggested Duration: 6 Days and 5 Nights\n\n\n”);

System.out.println (“7. Indonesia\n\n

Rich in cultural heritage, visit Indonesia for its encouraging natural beauty bounded by much more!\n\n

Air Tickets: Flight expenses for a round trip could cost you approx. INR 25000 and could be lesser if booked well in advance.\n\n

Stay: Hostels in Jakarta could cost INR 700 onwards per night.\n\n

Places to Eat: Three square warung (food stall) meals can cost as little as INR 120 per meal. Dining in decent local restaurants could cost INR 500-600 per day.\n\n

Places To Visit: Make sure to visit places like – Bali, Java, Yogyakarta, Jakarta, and Sumatra. Don’t miss out on things like Bali Village cycling tour, Spa treatments at places like Anika spa, water sports, and volcano tours.\n\n

Suggested Duration: 5 Days and 4 Nights\n\n\n\n”);  

System.out.println(“*************************************************************************************”);
 
 
System.out.println(“7 Best Places To Visit In Dalhousie In December\n”);

System.out.println(“**********************************************************************\n\n”);
System.out.println(“1. Garam Sadak\n\n

If you are one of those people who love going for a walk in the arms of nature, then this is just your place. Enveloped by lush green trees and a misty fog, this place is ideal for a stroll. The road derives its name from the warm and snug temperatures as well as the abundant sunlight it receives that makes it perfect for a Dalhousie trip in December.\n

It offers an enchanting view of the mountains, and is dotted with little shops and comfy restaurants that prove to be a paradise for the street food lovers.\n\n

Location: Dalhousie Village\n\n
Distance From General Post Office: 0.26 kilometers\n\n\n

 
 
2. Devi Dehra Rock Garden\n\n

Inaugurated in 1997, this little garden overlooking the majestic mountains was created by diverting the flow of a natural hill stream, and is a must on your list of places to visit in Dalhousie in December. It is a tranquil and relaxing spot away from the otherwise crowded Dalhousie, and is perfect for nature enthusiasts and photographers.It is also an exceptional spot for birdwatchers who can catch a glimpse of the yellow billed blue magpie or the Himalayan bulbul, also known as the white-cheeked bulbul.\n\n

Location: Devi Dehra, Dalhousie\n\n
Distance From Dalhousie: 17 kilometers\n\n
Entry Fee: Free\n\n\n

 
 
3. Norwood Paramdham\n\n

This religious site is an ashram dedicated to Swami Satyanand. It is famous as the place where Swami Satyanand stayed in Dalhousie and started Ram Sharnam, a spiritual sect.\n

Apart from its soothing aura, this place is also ideal for watching a breathtaking sunset that makes it one marvel at the unparalleled beauty of nature.\n\n

Location: Bakrota Hill\n\n
Distance from Gandhi Chowk: 5 kilometers\n\n
Entry Fee: Free\n\n\n

 
 
4. St. Patrick’s Church\n\n

Built in 1909, this beautiful church from the British era boasts of sublime interiors and emanates a calming atmosphere. It is a divine space that is surrounded by beautiful pine trees that offer a sight to behold.\n

Perfect for basking in nature’s glory, this church is one of the best places to visit in Dalhousie in December.\n\n

Location: Subhash Chandra Road, Cantt Area, Dalhousie\n\n
Distance From City Bus Stand: 3 kilometers\n\n
Timings: All days – 7 am to 7 pm\n\n\n

 
 
 
5.Subhash Baoli\n\n

Named after the famous freedom fighter Subhash Chandra Bose, this perennial spring is known for its appealing vistas. It is believed that Bose often visited this immaculately beautiful spring to meditate, and rumor has it that the medicinal properties of its water treated him of his illness.\n

Besides serving as a reminder of our freedom struggle, this spot is ideal for picnics, relaxing evening strolls, and is naturally one of the best places to visit in December.\n\n

Location: Alha, Chamba District, Dalhousie\n\n
Distance From City Centre: 5 kilometers\n\n
Timings: All days – 7am to 7pm\n\n
Entry Fee: Free\n\n\n

 
 
6. St. John’s Church\n\n

This church is a favourite among photographers because of its colonial architecture. Built by the Britishers, its pristine aura as well as historical significance entices visitors from all over the country.

The serene and peaceful ambience creates a captivating atmosphere making it one of the essential places to visit in Dalhousie in December.\n\n

Location: Gandhi Chowk, Dalhousie\n\n
Distance From City Bus Stand: 2 kilometers\n\n
Timings: All days – 7 am to 7 pm\n\n\n

 
 
7.Bara Pathar Temple\n\n

This sacred site enroute to Daikund Peak helps in embracing nature in all its glory. Strewn with flowers and lush green trees, it bewitches one with an awe-inspiring view of the valley. Deep into the woods, Bara Pathar is the abode of Bhulwani Mata.\n

Not only does it attract innumerable tourists with its alluring panorama but the drive up to this holy site is equally picturesque, and is one of the must things to do in Dalhousie in December.\n\n

Location: Chamba District, Dalhousie\n\n
Distance From Gandhi Chowk: 6 kilometers\n\n
Timings: All Days – 7am to 7pm\n\n\n\n”);

 

 

System.out.println(“PLACES TO VISIT INDIA IN THIS SUMMER\n”);

System.out.println(“*****************************************************************\n\n”);

System.out.println(“1. Spiti\n\n

Translating literally into The Middle Land, Spiti is one of the top places to visit in India during May that should be topping your Indian travel bucket list too. Home to one of the oldest monasteries, rugged motorable roads and panoramic landscapes, Spiti is one place that is blessed with natural beauty in abundance.\n\n

Weather in May: Spiti faces extreme weather conditions in winters which is why summers are considered perfect. Average temperature ranges from 18°C to 25°C.\n\n
Major Attractions: Dhankar Gompa, Kye Monastery, Pin Valley National Park, Chandratal Lake, Lahaul Valley, Komick Village and Trilokinath Temple\n\n
Things To Do: Tour around Spiti Valley, enjoy your bike ride and camp at Chandratal, go trekking to Hampta Pass, enjoy river rafting in Spiti and Pin, admire the beauty of flora and fauna in Pin Valley National Park, trek to Dhankar Lake and more.\n\n\n


 

2. Kerala\n\n

Boasting of an awesome coastline stretch of about 600 kilometers, this little piece of heaven called Kerala is not only one of the best tourist destinations for summer vacations but is also one of the best places to visit in India in May for honeymoon. A perfect blend of nature, mountains, backwaters and beaches lined with palm trees, a perfect Kerala tour package offers everything you need for a perfect summer holiday.\n\n

Weather in May: Summers in Kerala is pleasantly mild due to the presence of coastal breeze and bustling backwater and the temperature ranges from 22°C to 35°C.\n
Major Attractions: Munnar, Periyar National Park, Thekkady, Fort Kochi, Kovalam beaches, Alleppey, Bekal Fort and many more.\n\n
Things To Do: Don’t miss out on a Kathakali dance performance, tour the tea estates, take a houseboat ride in the backwaters, learn some Kalaripayattu techniques and get an ayurveda massage.\n\n\n


 

3. Mcleodganj\n\n\n

Taking the travelers one step closer to mother nature, Mcleodganj is one of the perfect places to visit in India in May with family, friends and even for solo trips. Settled in the foothills of Himalayas, Mcleodganj is a rare combination of an adventurer’s paradise and a peaceful haven.\n\n

Weather in May: Summers in Mcleodganj is the best time to get out and explore this adventurous city with average temperature ranging from 22°C to 38°C.\n\n
Major Attractions: Namgyal Monastery, Tsuglagkhang, Bhagsu Nag temple, Bhagsu Falls, Tibetan Museum, Church of St. John, Triund and Dal Lake.\n\n
Things To Do: Go on a sightseeing tour of the city, enjoy boating in Dal Lake, go trekking, camping, and hiking on Triund, chill at Shiva Cafe and enjoy shopping in the local markets.\n\n\n


 

 

4. Lansdowne\n\n

A hidden gem in the state of Uttarakhand, Lansdowne is the most surreal hill station of North India when it comes to the top places to visit in India in May. A tranquil abode of charm and peace, a trip to Lansdowne is sure to be unforgettable.\n\n

 

Weather in May: Find yourself amidst peaceful environs during summers in Lansdowne when temperature ranges from 15°C to 30°C.\n\n
Major Attractions: Tip n Top, St. Mary’s Church, Tarkeshwar Mahadev Temple, War memorial, Darwan Singh Museum and Bhulla Lake\n\n.
Things To Do: Go camping, enjoy boating in Bhulla Lake, experience trekking to Snow Viewpoint, hike to Tip n Top, indulge in some nature walking throughout Lansdowne and visit Kalagarh Tiger Reserve.\n\n\n


 

 

5.Kausani\n\n

Kausani is yet another popular hill station of Uttarakhand which is perched high on top at about 1800 meters above the sea level. Offering panoramic views of Trisul and Nanda Devi Hills, witnessing a sunrise over the Himalayas is a must experience for everyone in Kausani.\n\n

Weather in May: Kausani enjoys a moderate temperature during summers and the average temperature lies between 9°C to 26°C.\n\n
Major Attractions: Rudradhari Falls & Caves, Gandhi Ashram, pear farms and tea estates in Kausani, Anasakti Ashram and Baijnath Temple.\n\n
Things To Do: Enjoy mystical sunrise at Nanda Devi, enjoy trekking to Adi Kailash and Bageshwar to Sunderdhunga, experience the best of bird watching and more.\n\n\n


 

6. Chail\n\n

Located 2250 meters above the sea level, Chail is a beautiful hill station which is often referred to as the summer capital. An overdose on hills and misty clouds, Chail also boasts of being home to the world’s highest cricket ground.\n\n

Weather in May: Chail enjoys a pleasant and mild summers with an average temperature of 15°C to 24°C.
Major Attractions: Palace hotel, Sidh Baba temple, Kali temple, Chail wildlife sanctuary and the Himalayan nature park.\n\n
Things To Do: Must experience living in a glass cottage, enjoy night camping in jungles of Chail, go horse riding in Kufri, go trekking, mountain biking and more.\n\n”);

}

  public static void main(String args[])throws IOException
  {
air obj=new air();
obj.airways();
}
}
