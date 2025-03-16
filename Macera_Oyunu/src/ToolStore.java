public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player ,"magaza");
    }
    @Override
    public  boolean onLocation(){
        System.out.println("------ Magazaya Hosgeldiniz ------ ");
        boolean showMenu=true;
        while(showMenu){
            System.out.println("1-Silahlar");
            System.out.println("2-Zırhlar");
            System.out.println("3-Cıkıs yap");
            System.out.println("Seciminiz");
            int selectCase=input.nextInt();
            while (selectCase<1||selectCase>3){
                System.out.println("gecersiz değer tekrar deneyiniz");
                selectCase=input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz");
                    showMenu=false;
                    break;


            }
        }
        return true;

    }
    public void printWeapon(){//Silah
        System.out.println("*****Silahlar*****");
        for(Weapon w:Weapon.weapons()){
            System.out.println(+w.getId()+"-"+w.getName()+"<Para : "+w.getPrice()+",Hasar : "+w.getDamage()+" >");
        }
        System.out.println("0-Cıkıs Yap");

    }
    public void buyWeapon(){
        System.out.println("Bir silah seciniz");
        int selectWeaponId=input.nextInt();
        while (selectWeaponId<1||selectWeaponId>Weapon.weapons().length){
            System.out.println("gecersiz değer tekrar deneyiniz");
            selectWeaponId=input.nextInt();
        }
        if (selectWeaponId !=0){
            Weapon selectedWeapon=Weapon.getWeaponObjById(selectWeaponId);
            if(selectedWeapon!=null){//gelen değerimiz bos değilse kontrol yani silah secildi mi kontrol
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Bakiyeniz yetersizdir");
                }else {//satın almanın gerceklestiği alan
                    System.out.println(selectedWeapon.getName()+" silahını satın aldınız");
                    int newMoney=this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(newMoney);
                    System.out.println("Kalan paranız: "+ this.getPlayer().getMoney());
                    System.out.println("önceki silahınız "+ this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("yeni silahınız "+  this.getPlayer().getInventory().getWeapon().getName());

                }
            }
        }

    }
    public void printArmor(){//zırh
        System.out.println("*********Zırhlar*********");
        for(Armor a:Armor.armors()){
            System.out.println(+a.getId()+"-"+a.getName()+"<Para : "+a.getPrice()+",Hasar : "+a.getBlock()+" >");
        }
        System.out.println("0-Cıkıs Yap");
    }
    public void buyArmor(){
        System.out.println("Bir zırh seciniz");
        int selectArmorId =input.nextInt();
        while (selectArmorId<0||selectArmorId>Weapon.weapons().length){
            System.out.println("gecersiz değer tekrar deneyiniz");
            selectArmorId=input.nextInt();
        }
        if (selectArmorId!=0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorId);
            if (selectedArmor!=null){
                if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır");
                }else{
                    System.out.println(selectedArmor.getName()+" zırhını satını aldınız! ");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan Bakiye: "+this.getPlayer().getMoney());
                }
            }
        }
    }
}
