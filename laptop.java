import java.util.Arrays;
import java.util.Scanner;

public class laptop
{
    public static void main(String []args)
    {
        Mylaptop []arr= new Mylaptop[4];
        Scanner sc =new Scanner(System.in);
        for(int i=0;i<4;i++)
        {
            int a=sc.nextInt();sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextInt();sc.nextLine();
            int e= sc.nextInt();sc.nextLine();
            arr[i]= new Mylaptop(a,b,c,d,e);
        }
        String inputbrand=sc.nextLine();
        String inputosType=sc.nextLine();


        int c1=countOfLaptopsByBrand(arr,inputbrand);
        if(c1>0)
        {
            System.out.println(c1);
        }
        else
        {
            System.out.println("This given brand no available");
        }


        Mylaptop obj= searchLaptopByOsType(arr,inputosType);
        if(obj==null)
        {
            System.out.println("nothing");
        }
        else
        {
            System.out.println(obj.laptoId);
            System.out.println(obj.rating);
        }
    }



    public static int countOfLaptopsByBrand(Mylaptop[]arr,String input)
    {
        int c=0;
        for(int i=0;i<arr.length;i++)
        {
            if (arr[i].brand.equalsIgnoreCase(input) && arr[i].rating > 3)
            {
                c=c+1;
            }
        }
        return c;
    }



    public static Mylaptop searchLaptopByOsType(Mylaptop[]arr, String input2)
    {
        int ary[]= new int [2];
        int j=0,l=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].osType.equalsIgnoreCase(input2))
            {
                ary[j]=arr[i].laptoId;
                j++;
            }
        }
        Arrays.sort(ary);
        for(int i=ary.length;i<0;i--)
        {
            for(int m=0;m<arr.length;m++)
            {
                if(ary[i]==arr[m].laptoId)
                {
                    return arr[m];
                }
            }
        }
        return null;
    }
}
class Mylaptop
{
    int laptoId;
    String brand;
    String osType;
    double price;
    int rating;
    public Mylaptop(int laptoId,String brand,String osType,double price,int rating)
    {
        this.laptoId=laptoId;
        this.brand=brand;
        this.osType=osType;
        this.price=price;
        this.rating=rating;
    }

    public int getLaptoId()
    {
        return laptoId;
    }

    public void setLaptoId(int laptoId)
    {
        this.laptoId = laptoId;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getOsType()
    {
        return osType;
    }

    public void setOsType(String osType)
    {
        this.osType = osType;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }
}