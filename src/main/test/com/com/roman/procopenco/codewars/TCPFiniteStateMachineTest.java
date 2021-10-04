package com.roman.procopenco.codewars;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;
import org.junit.Test;

public class TCPFiniteStateMachineTest {

  @Test
  public void SampleTests() {
    assertEquals("CLOSE_WAIT",   TCPFiniteStateMachine.traverseStates(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN"}));
    assertEquals("ESTABLISHED",  TCPFiniteStateMachine.traverseStates(new String[] {"APP_PASSIVE_OPEN", "RCV_SYN","RCV_ACK"}));
    assertEquals("LAST_ACK",     TCPFiniteStateMachine.traverseStates(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN","APP_CLOSE"}));
    assertEquals("SYN_SENT",     TCPFiniteStateMachine.traverseStates(new String[] {"APP_ACTIVE_OPEN"}));
    assertEquals("ERROR",        TCPFiniteStateMachine.traverseStates(new String[] {"APP_PASSIVE_OPEN","RCV_SYN","RCV_ACK","APP_CLOSE","APP_SEND"}));
  }

  @Test
  public void SampleTestsShortSolution() {
    assertEquals("CLOSE_WAIT",   TCPFiniteStateMachine.traverseStatesShort(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN"}));
    assertEquals("ESTABLISHED",  TCPFiniteStateMachine.traverseStatesShort(new String[] {"APP_PASSIVE_OPEN", "RCV_SYN","RCV_ACK"}));
    assertEquals("LAST_ACK",     TCPFiniteStateMachine.traverseStatesShort(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN","APP_CLOSE"}));
    assertEquals("SYN_SENT",     TCPFiniteStateMachine.traverseStatesShort(new String[] {"APP_ACTIVE_OPEN"}));
    assertEquals("ERROR",        TCPFiniteStateMachine.traverseStatesShort(new String[] {"APP_PASSIVE_OPEN","RCV_SYN","RCV_ACK","APP_CLOSE","APP_SEND"}));
  }
}