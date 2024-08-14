import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        BinaryTree tree = new BinaryTree();
        List<Integer> initialNumbers = new ArrayList<>();
        List<Integer> newNumbers = new ArrayList<>();

        System.out.println("Gerando 100 números aleatórios...");
        for (int i = 0; i < 100; i++) {
            initialNumbers.add(random.nextInt(101));
        }
        System.out.println("Números aleatórios gerados: " + initialNumbers);

        for (int num : initialNumbers) {
            tree.insert(num);
        }

        System.out.println("Balanceando a árvore inicial...");
        tree.buildBalancedTree();
        
        tree.printTree("Árvore balanceada inicial:");
        tree.printInOrder();

        System.out.println("Gerando 20 novos números aleatórios...");
        for (int i = 0; i < 20; i++) {
            newNumbers.add(random.nextInt(101));
        }
        System.out.println("Novos números aleatórios gerados: " + newNumbers);

        for (int num : newNumbers) {
            tree.insert(num);
        }

        System.out.println("Rebalanceando a árvore após inserção...");
        tree.buildBalancedTree();
        
        tree.printTree("Árvore balanceada após inserção:");
        tree.printInOrder();
    }
}
