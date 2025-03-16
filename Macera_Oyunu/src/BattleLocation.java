import java.util.Random;

public class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;//odul
    private int maxObbstacle;

    public BattleLocation(Player player, String name,Obstacle obstacle,String award,int maxObbstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObbstacle=maxObbstacle;

    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Suan buradasınız "+this.getName());
        System.out.println("Dikkatli OL "+obsNumber+" tane "+this.getObstacle().getName()+ " yasıyor");
        System.out.println("<S>avas veya <K>ac");
        String selectCase=input.nextLine();
        selectCase=selectCase.toUpperCase();
        if(selectCase.equals("S")&&combat(obsNumber)){
       if (combat(obsNumber)){
           System.out.println(this.getName()+" tüm dusmanları yendiniz");
           return true;
       }
        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println(" öldünüzz");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){//Canavarrlarla savasma dongusu

        for(int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());//ilk canavar öldükten sonra diğer canavarın cannın yenilenmesi
            playerStarts();//kullanıcı degerleri
            obstacleStarts( i);//canavarın degerleri
            while (this.getPlayer().getHealth()>0&&this.getObstacle().getHealth()>0){
                System.out.println("<V>ur veya <K>ac");
                String selectCase=input.nextLine().toUpperCase();
                if(selectCase.equals("V")){
                    System.out.println("Siz Vurdunuz");
                    obstacle.setHealth(this.obstacle.getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("Canavar size vurdu");
                        int obstactleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstactleDamage<=0){
                            obstactleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstactleDamage);
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("düsmanı yendiniz");
                System.out.println(this.getObstacle().getAward()+" para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("güncel paranız "+this.getPlayer().getMoney());
            }else{
                return false;
            }
        }

        return true;
    }
    public void playerStarts(){
        System.out.println("Oyuncu Degerleri");
        System.out.println("***********************************");
        System.out.println("Saglık: "+this.getPlayer().getHealth());
        System.out.println("Silah: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar: "+this.getPlayer().getTotalDamage());
        System.out.println("Bloklama: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: "+this.getPlayer().getMoney());


    }
    public void obstacleStarts(int i ){
        System.out.println(i+". "+this.getObstacle().getName()+ " degerleri");
        System.out.println("*******************************");
        System.out.println("Saglık: "+this.getObstacle().getHealth());
        System.out.println("Hasar: "+this.getObstacle().getDamage());
        System.out.println("öDÜL: "+this.getObstacle().getAward());

    }
    public void afterHit(){
        System.out.println("Canınız: "+this.getPlayer().getHealth());
        System.out.println(this.obstacle.getName()+ " canı: "+this.getObstacle().getHealth());
        System.out.println("----------------------------");
    }
    public int randomObstacleNumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxObbstacle())+1;

    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObbstacle() {
        return maxObbstacle;
    }

    public void setMaxObbstacle(int maxObbstacle) {
        this.maxObbstacle = maxObbstacle;
    }
}
