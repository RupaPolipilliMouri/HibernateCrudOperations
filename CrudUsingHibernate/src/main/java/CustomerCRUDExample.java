import java.util.Scanner;

import com.mouritech.crudwithhibernate.service.CustomerService;

public class CustomerCRUDExample {
	public static void main(String[] args) {
		char ch = 'y';
		String transaction = null;
		Scanner sc = new Scanner(System.in);
		CustomerService empService = new CustomerService();
		while(ch == 'y') {
			System.out.println("Enter the transaction type");
			System.out.println("save : to insert a new Customer");
			System.out.println("update : to update an Customer");
			System.out.println("delete : to delete an Customer");
			System.out.println("getall : to get all Customer details");
			System.out.println("get : to get an Customer detail");
			System.out.println("deleteName: to deleteName an customer details");
			transaction = sc.next();
			switch (transaction) {
			case "save":
				empService.customerSave();
				break;
			case "getall":
				empService.getAllCustomer();
				break;
			case "delete":
				empService.deleteCustomer();
				break;
			case "update":
				empService.getDetailsToUpdate();
				break;
			case "get":
				empService.getCustomerById();
				break;
			case "deleteName":
				empService.getCustomerByName();
				break;
			default:
				System.out.println("Not a valid transaction");
				break;
			}
			System.out.println("Do you want to continue (y-yes/n-no)");
			ch = sc.next().charAt(0);
		}

		sc.close();
	}

}