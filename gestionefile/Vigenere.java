package gestionefile;
public class Vigenere implements Runnable{

    private int ir;
    private int fr;
    private int ic;
    private int fc;
    private Matrice mt;

    public Vigenere(int ir, int fr, int ic, int fc, Matrice mt) {
        this.ir = ir;
        this.fr = fr;
        this.ic = ic;
        this.fc = fc;
        this.mt = mt;
    }

    @Override
    public void run() {
        popola();
    }

    private void popola(){
        int c,r,car;
        for(r=ir; r<fr; r++) {
            for(c=ic; c<fc; c++) {
                car = r + c + 65;
                if(car>90) {
                    car = car - 26;
                }
                this.mt.setElemento(r, c, car);
            }
        }
    }
}

