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

        System.out.println("\nPre-Order");
        ab.imprimirArbolPreOrder();
        System.out.println("\nPost-Order");
        ab.imprimirArbolPostOrder();

        System.out.println("\nBuscar 23");
        System.out.println(ab.search(23));
        if(!ab.search(77)){
            System.out.println("No encontro");
        }

        System.out.println("Nombre: Nicolas Cedillo");

        System.out.println("\nAltura: " + ab.getHeight());

        System.out.println("Weight: " + ab.getWeight());

        System.out.println("In-order");
        ab.imprimirArbolInOrder();

        System.out.println("\nIn-Order con altura");
        ab.imprimirArbolInOrderWithHeight();

        System.out.println("\nIn-Order con equilibrio");
        ab.imprimirArbolInOrderEquilibrio();

        System.out.println("\n\nEsta equilibrado: " + ab.estaEquilibrado());
        System.out.println("Agregamos el valor: " + 15);
        ab.insert(15);

        System.out.println("\nIn-Order con equilibrio");
        ab.imprimirArbolInOrderEquilibrio();
        System.out.println("\nEsta equilibrado: " + ab.estaEquilibrado());

        System.out.println("Nodos desequilibrados: ");
        ab.listadoDesequilibrados();
    }
}
