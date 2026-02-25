/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package anagrafe;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author ranasgalla.niccolo
 */


public class GestioneFile {

    /**
     * Legge i dati dal file di testo e crea una lista di oggetti Studente.
     * * @param nomeFile Il percorso o nome del file da leggere (es. "studenti.txt")
     * @return Un ArrayList contenente gli studenti caricati dal file
     */
    public ArrayList<Studente> caricaDaFile(String nomeFile) {
        
        ArrayList<Studente> studentiCaricati = new ArrayList<>();
        File file = new File(nomeFile);
        

        // Se il file non esiste ancora, ritorniamo una lista vuota senza errori
        if (!file.exists()) {
            System.out.println("Nessun file trovato");
            return studentiCaricati;
        }

        // Utilizziamo il try-with-resources per chiudere automaticamente il file
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            
            // Leggiamo il file riga per riga finché non finisce
            while ((linea = br.readLine()) != null) {
                // Dividiamo la riga usando i due punti ":" come separatore
                String[] dati = linea.split(":");
                
                // Controlliamo che la riga sia formattata correttamente (deve avere 3 parti)
                if (dati.length == 3) {
                    String matricola = dati[0].trim();
                    String nome = dati[1].trim();
                    String cognome = dati[2].trim();
                    
                    // Creiamo l'oggetto Studente (richiede che la classe Studente sia già definita)
                    Studente s = new Studente(matricola, nome, cognome);
                    studentiCaricati.add(s);
                }
            }
            System.out.println("Dati caricati con successo da " + nomeFile);
            
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }

        return studentiCaricati;
    }

    /**
     * Salva la collezione di studenti su un file di testo.
     * * @param nomeFile Il percorso o nome del file su cui scrivere (es. "studenti.txt")
     * @param studenti La Collection di studenti da salvare
     */
    public void salvaSuFile(String nomeFile, Collection<Studente> studenti) {
        // Utilizziamo il try-with-resources per chiudere automaticamente il file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFile))) {
            
            for (Studente s : studenti) {
                // Creiamo la stringa nel formato richiesto: matricola:nome:cognome
                String riga = s.getMatricola() + ":" + s.getNome() + ":" + s.getCognome();
                
                // Scriviamo la riga e andiamo a capo
                bw.write(riga);
                bw.newLine();
            }
            System.out.println("Dati salvati con successo in " + nomeFile);
            
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }
}
