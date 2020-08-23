package datePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class Operation implements Serializable {

	LocalDate output;
	LocalDate inputDateForOperation;
	String methodType;
	String methodParameter;
	int paramValue;

	public Operation(LocalDate output, LocalDate inputDateForOperaion, String methodType, String methodParameter,
			int paramValue) {
		super();
		this.output = output;
		this.inputDateForOperation = inputDateForOperaion;
		this.methodType = methodType;
		this.methodParameter = methodParameter;
		this.paramValue = paramValue;
	}

	public void serliazeOperation() throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Abhimanyu\\Desktop\\SessionForDateCalculator.ser");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new Operation(output, inputDateForOperation, methodType, methodParameter, paramValue));
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
			Operation op = (Operation) readObject;
			System.out.println(op.output);
			System.out.println(op.inputDateForOperation);
			System.out.println(op.methodType);
			System.out.println(op.paramValue);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
