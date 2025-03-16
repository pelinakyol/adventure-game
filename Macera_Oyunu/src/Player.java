import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SortedMap;

public class Player {

    private String name;//oyuncu player name
    private int damage;
    private int health;
    private int orijinalHealth;
    private int money;
    private int id;
    private String charName;
    private Inventory inventory;
    private Scanner input=new Scanner(System.in);

//geri kalan dördünü sectirecegimiz için yani dısardan almayacagımız için constructora eklemedik
    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void selectChar(){
        GameCharacter[]charList={new Samurai(),new Archer(),new Knight()};
      for (GameCharacter gameChar:charList){
          System.out.println("Karakter "+gameChar.getCharName()+" Hasar\t"+gameChar.getDamage()+" Sağlık\t"+gameChar.getHealth()+"  Para\t"+gameChar.getMoney()+" id:\t"+gameChar.getId());
      }
        System.out.println("kullanmak istediğiniz karakteriin id degerini seciniz");
      switch (input.nextInt()){
          case 1:
              initPlayer(new Samurai());
              break;
          case 2:
              initPlayer(new Archer());
              break;
          case 3:
              initPlayer(new Knight());
              break;
          default:
              System.out.println("tekrar oyuncu secmeyi deneyiniz gecersiz iid girdiniz");





      }


      }
    public void initPlayer(GameCharacter gameChar){
        this.setCharName(gameChar.getCharName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrijinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setId(gameChar.getId());

    }
    public void printInfo(){
        System.out.println("Karakter "+this.getCharName()+" Silahınız: "+this.getInventory().getWeapon().getName()+
                " Zırhınız "+this.getInventory().getArmor().getName()+
                " Bloklama "+this.getInventory().getArmor().getBlock()+
                " Hasar\t"+this.getTotalDamage()+" Sağlık\t"+this.getHealth()+"  Para\t,"+this.getMoney());
    }
    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }
}
