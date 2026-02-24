/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package anagrafe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
/**
 *
 * @author ranasgalla.niccolo
 */
public class Anagrafe {
   
    // Strutture dati obbligatorie
    private ArrayList<Studente> listaStudenti;
    private HashSet<String> insiemeMatricole;
    private HashMap<String, Studente> mappaStudenti;

    // Costruttore
    public Anagrafe() {
        this.listaStudenti = new ArrayList<>();
        this.insiemeMatricole = new HashSet<>();
        this.mappaStudenti = new HashMap<>();
    }

    /**
     * Aggiunge uno studente alle strutture dati.
     * @param s L'oggetto Studente da aggiungere
     * @return true se l'inserimento ha successo, false se la matricola esiste già o lo studente è null
     */
    public boolean aggiungiStudente(Studente s) {
        if (s == null || s.getMatricola() == null) {
            return false;
        }
        
        // Controllo tramite HashSet se la matricola è già presente (ricerca O(1))
        if (insiemeMatricole.contains(s.getMatricola())) { 
            return false;
        } else {
        }

        // Se non esiste, aggiungo lo studente in tutte e tre le strutture dati
        listaStudenti.add(s);
        insiemeMatricole.add((String) s.getMatricola());
        mappaStudenti.put((String) s.getMatricola(), s);
        
        return true;
    }

    /**
     * Elimina uno studente partendo dalla sua matricola.
     * @param matricola La matricola dello studente da rimuovere
     * @return true se l'eliminazione ha successo, false se la matricola non esiste
     */
    public boolean eliminaStudente(String matricola) {
        if (matricola == null || !insiemeMatricole.contains(matricola)) {
            return false; // Studente non trovato
        }

        // Recupero l'oggetto studente dalla mappa prima di eliminarlo
        Studente s = mappaStudenti.get(matricola);

        // Rimuovo da tutte e tre le strutture dati
        listaStudenti.remove(s);
        insiemeMatricole.remove(matricola);
        mappaStudenti.remove(matricola);

        return true;
    }

    /**
     * Cerca uno studente partendo dalla matricola.
     * @param matricola La matricola da cercare
     * @return L'oggetto Studente se trovato, altrimenti null
     */
    public Studente cercaStudente(String matricola) {
        // La HashMap permette una ricerca efficiente in O(1)
        return mappaStudenti.get(matricola);
    }

    /**
     * Restituisce tutti gli studenti memorizzati.
     * @return Una Collection contenente tutti gli studenti
     */
    public Collection<Studente> getTuttiStudenti() {
        return listaStudenti;
    }

    /**
     * Restituisce il numero totale di studenti registrati.
     * @return Il numero di studenti
     */
    public int numeroStudenti() {
        return listaStudenti.size();
    }
    
    /**
     * METODO EXTRA UTILE PER LA GUI: Svuota l'anagrafe 
     * (Molto comodo prima di caricare i dati da file per non duplicare le voci)
     */
    public void svuotaAnagrafe() {
        listaStudenti.clear();
        insiemeMatricole.clear();
        mappaStudenti.clear();
    }
}
    //public static void main(String[] args) {
        // TODO code application logic here
    
    

