import controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        System.out.println("In-order");
        ab.imprimirArbolInOrder();
        System.out.println("\nPre-Order");
        ab.imprimirArbolPreOrder();
        System.out.println("\nPost-Order");
        ab.imprimirArbolPostOrder();
    }
}
