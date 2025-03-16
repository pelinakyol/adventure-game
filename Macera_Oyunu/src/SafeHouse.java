public   class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }
    @Override
   public  boolean onLocation(){
        System.out.println("Güvenli Evdesiniz ");
        System.out.println("Canınız Yenilendi");
        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
        return true;
    }
}
