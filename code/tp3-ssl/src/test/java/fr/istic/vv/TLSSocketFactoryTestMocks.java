package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {
	
	private TLSSocketFactory tlsSocketFactory;
    private SSLSocket mockSSLSocket;

    @BeforeEach
    public void setUp() {
        tlsSocketFactory = new TLSSocketFactory();
        mockSSLSocket = mock(SSLSocket.class);  // Mock de SSLSocket
    }

	@Test
    public void preparedSocket_NullProtocols()  {
		// Crée un mock pour SSLSocket
	    SSLSocket mockSSLSocket = mock(SSLSocket.class);
	    
	    // Mock les protocoles retournés comme null
	    when(mockSSLSocket.getSupportedProtocols()).thenReturn(null);
	    when(mockSSLSocket.getEnabledProtocols()).thenReturn(null);

	    // Appel de la méthode à tester
	    tlsSocketFactory.prepareSocket(mockSSLSocket);

	    // Vérifie que setEnabledProtocols n'a pas été appelé si les protocoles sont null
	    verify(mockSSLSocket, never()).setEnabledProtocols(any());
    }
	
	@Test
    public void typical()  {
		String[] supportedProtocols = {"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        String[] enabledProtocols = {"SSLv3", "TLSv1"};


		// Crée un mock pour SSLSocket
	    SSLSocket mockSSLSocket = mock(SSLSocket.class);
	    
	    // On configure les mocks pour retourner les protocoles définis ci-dessus
        when(mockSSLSocket.getSupportedProtocols()).thenReturn(supportedProtocols);
        when(mockSSLSocket.getEnabledProtocols()).thenReturn(enabledProtocols);


	    // Appel de la méthode à tester
	    tlsSocketFactory.prepareSocket(mockSSLSocket);

	    // Vérification que setEnabledProtocols est bien appelé avec les protocoles triés
        String[] expectedProtocols = {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"};
        verify(mockSSLSocket, times(1)).setEnabledProtocols(expectedProtocols);

    }
	
	
}