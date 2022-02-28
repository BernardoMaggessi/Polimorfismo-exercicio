package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> product = new ArrayList<>();
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + "data: ");
			System.out.println("commom, user or imported (c/u/i) ?");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.println("Name:");
			String name = sc.nextLine();
			System.out.println("price:");
			Double price = sc.nextDouble();

			if (ch == 'c') {
				product.add(new Product(name, price));
			} else if (ch == 'i') {
				System.out.println("Custom fee:");
				Double customsFee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customsFee));
			} else {
				System.out.println("Manufacture Date (DD/MM/YYYY):");
				Date date = sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, date));
			}
		}
		System.out.println();
		System.out.println("Price Tags: ");
		for (Product p : product) {
			System.out.println(p.priceTag());
		}
		sc.close();
	}

}
