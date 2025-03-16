import java.util.Scanner;

public class Game {

    private Scanner input=new Scanner(System.in);


    public void start(){
        System.out.println("Macera oyununa hosgeldiniz!");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName=input.nextLine();
        Player player=new Player(playerName);
        System.out.println("Sayin "+player.getName()+" hosgeldiniz");
        System.out.println("*******************************************************");
        System.out.println("lütfen oyuna baslamak için bir karakter seciniz");
        player.selectChar();
        Location location=null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("########Bölgeler:#########");
            System.out.println();
            System.out.println("1-Güvenli Ev");
            System.out.println("2- Magaza");
            System.out.println("3- Magara-> Ödül Yemek Dikkatli ol zombi cıkabilir!!!");
            System.out.println("4- Orman->Ödül Odun Dikkatli ol vampir cıkabilir");
            System.out.println("5- Nehir-> Ödül Suu Dikkatli OL ayı cıkabilir!!!");
            System.out.println("0- Cıkıs Yap------>Oyunu sonlandırın");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seciniz:");

            switch (input.nextInt()){
                case 0:
                    location=null;
                    break;
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location=new ToolStore(player);//suan hangi karakter varsa kullanıcı hangisni
                    ///sectiyse onu gönderiyor
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;

                case 5:
                    location=new River(player);
                    break;
                default:
                    System.out.println("lütfen gecerli bir lokasyon seciniz");
            }
            if (location==null){
                System.out.println("Oyun Bitti Tekrar görüsürüüz");
break;
            }

            if(  !location.onLocation() ){
                System.out.println("Game Over");
                break;


            }

        }


    }

}
