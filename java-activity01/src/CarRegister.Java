import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double price;

    public Vehicle(String brand, String model, int year, double price){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Brand: "+brand+", Model: "+model+", Year: "+year+ ", Price: R$ "+price;
    }
}

class Car extends Vehicle {
        private int NumberOfDoors;

        public Car(String brand, String model, int year, double price, int NumberOfDoors) {
            super(brand, model, year, price);
            this.NumberOfDoors = NumberOfDoors;
        }

        @Override
        public String toString() {
            return "[Carro] "+super.toString()+", Portas: "+NumberOfDoors; 
        }

}

class Motorcycle extends Vehicle {
    private int power;

    public Motorcycle(String brand, String model, int year, double price, int power){
        super(brand, model, year, price);
        this.power = power;
    }
    @Override
    public String toString(){
        return "[Motorcycle] "+super.toString()+", Power: "+power+"cc";
    }
}

public class CarRegister {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        List<Vehicle> list = new ArrayList<>();

        System.out.print("Quantos veiculos deseja cadastrar (1 a 10)?");
        int qtd = sc.nextInt();
        sc.nextLine();

        if (qtd <1 || qtd > 10){
            System.out.println("Quantiadade invalida. Encerrando o programa.");
            return;
        }

        for (int i = 0; i < qtd; i++) {
            System.out.println("\nCadastro do veiculo "+ (i + 1) + ":");
            System.out.print("Tipo (C para CARRO /M para Moto): ");
            String type = sc.nextLine().trim().toUpperCase();

            System.out.print("Marca: ");
            String brand = sc.nextLine();

            System.out.print("Modelo: ");
            String model = sc.nextLine();

            System.out.print("Ano: ");
            int year = sc.nextInt();

            System.out.print("Preço: ");
            double price = sc.nextDouble();

            if (type.equals("C")) {
                System.out.print("Numero de portas: ");
                int NumberOfDoors = sc.nextInt();
                sc.nextLine();
                list.add(new Car(brand, model, year, price, NumberOfDoors));
            }else if (type.equals("M")) {
                System.out.print("Cilindrada (cc): ");
                int power = sc.nextInt();
                sc.nextLine();
                list.add(new Motorcycle(brand, model, year, price, power));
            } else {
                System.out.println("Tipo invalido! Veiculo ignorado.");
                i--;
            }


        }
        System.out.print("\nInfomre o preco minimo para filtrar: ");
        double minimalPrice = sc.nextDouble();

        System.out.print("\n--- Veiculos com preço acima de R$ "+minimalPrice+ " ---");
        boolean found = false;

        for (Vehicle v : list) {
            if (v.getPrice() > minimalPrice) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nenhum veiculo encontrado com preco acima de R$ "+minimalPrice);
        }

        sc.close();
    }    
}
