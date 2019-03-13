package swingSandbox.AExample;


import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {

    public static void main(String[] args){
        EventQueue.invokeLater(() ->
        {
            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
/*
W każdym programie opartym na swingu trzeba poradzić sobie z dwoma zagadnieniami technicznymi.

Po pierwsze konfiguracja każdego komponentu Swing musi odbyć się w wątku dystrybucji zdarzeń(eng. Event Dispatch Thread).

Okienko jest komponentem. Linijki 12-14 odpowiadają za konfiguracje komponentu. (pozostała część konfiguracji ramki odbywa się w konstruktorze)

poniższy fragment wykona INSTRUKCJE w wątku dystrybucji zdarzeń.
    EventQueue.invokeLater(() ->
            {
             INSTRUKCJE
            });

Wątek dystrybucji zdarzeń steruje wysyłaniem zdarzeń, jak kliknięcie przyciskiem myszy lub wciśnięcie klawisza na klawiaturze, do elementów interfejsu użytkownika.

Po drugie musimy określić co ma się stać kiedy użytkownik zamknie ramke aplikacji.
W tym przypadku chcemy aby program został zamkniety linijka 13


PS. Teoretycznie nie musimy inicjować każdego komponentu w wątku dystrybucji zdarzeń ale wtedy mogą wystąpić Errory, mogą ale nie muszą.
 */
