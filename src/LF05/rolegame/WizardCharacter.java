package LF05.rolegame;

public class WizardCharacter extends GameCharacter{

    private int mana;

    public WizardCharacter(String name, int strength, int mana) {
        super(name, strength);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void drinkMagicPot() {
        mana += 3;
    }

    public void castMagic() throws MissingStrengthException {
        if (getStrength() < 1) {
            throw new MissingStrengthException("zaubern",getName());
        } else {
            mana--;
        }
    }

    @Override
    public String toString() {
        return super.toString()+
                ",\nTyp: Zauberer,\n" +
                "Magiest�rke: "+ mana;
    }
}
