import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class FirestoreInit {
    public static void main(String[] args) throws IOException {
        // Path to your service account key file
        FileInputStream serviceAccount = new FileInputStream("recources/advanced/software/dev/path to key");

        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();

        // Initialize Firebase app
        FirebaseApp.initializeApp(options);

        // Get Firestore instance
        Firestore db = FirestoreClient.getFirestore();//get data from this database

    }
}