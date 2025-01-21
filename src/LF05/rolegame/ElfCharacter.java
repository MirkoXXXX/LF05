package LF05.rolegame;

public class ElfCharacter extends GameCharacter{

    public ElfCharacter(String name, int strength) {
        super(name, strength);
    }

    public void rennen() throws MissingStrengthException {
        if (getStrength() < 2) {
            throw new MissingStrengthException("rennen",getName());
        } else {
            setStrength(getStrength() - 2);
        }
    }

    @Override
    public String toString() {
        return super.toString()+",\nTyp: Elf";
    }
}
