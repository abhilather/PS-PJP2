package datePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OperationListSerializer {

	ArrayList<Operation> operationsList;

	public OperationListSerializer(ArrayList<Operation> operationsList) {
		super();
		this.operationsList = operationsList;
	}

	public void serliazeOperation() throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Abhimanyu\\Desktop\\SessionForDateCalculator.ser",
				true);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(operationsList);
			//			oos.writeObject(new Operation(output, inputDateForOperation, methodType, methodParameter, paramValue));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deserializeOperation() throws FileNotFoundException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Abhimanyu\\Desktop\\SessionForDateCalculator.ser");
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object readObject = ois.readObject();
			ArrayList<Operation> op = (ArrayList<Operation>) readObject;
			System.out.println(op);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
