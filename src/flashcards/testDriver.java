package flashcards;

import java.io.*;

class testDriver {
    public static void main(String[] args) {
        // Records records = new Records();

        Records records = null;
        try {
            FileInputStream fileIn = new FileInputStream("records.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            records = (Records) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException f) {
            records = new Records();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Records class not found");
            c.printStackTrace();
            return;
        }
        // Writing to database after all the work
        try {
            FileOutputStream fileOut =
            new FileOutputStream("records.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(records);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in records.ser");
         } catch (IOException i) {
            i.printStackTrace();
         }
    }
}

/* Major Tasks:
 * 1) Deserialisations and running the server -> DONE
 * 2) Adaptive learning interval implementation -> First call attempt card then update learning interval once recall value is obtained. DONE
 * 3) Activity map -> getNumCardsSeenPerDay. DONE
 * 4) Edit and delete cards in categories. Edit cards done, delete cards to be done
 * 5) Finish getData method -> displayQuestion DONE
 * 6) Implement deck class -> DONE
 * 6) get deck of cards which returns arraylist of cards -> DONE
 */
