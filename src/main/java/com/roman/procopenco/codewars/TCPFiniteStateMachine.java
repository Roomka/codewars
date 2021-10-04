package com.roman.procopenco.codewars;

import java.util.HashMap;
import java.util.Map;

/**
 * Automatons, or Finite State Machines (FSM), are extremely useful to programmers when it comes to
 * software design. You will be given a simplistic version of an FSM to code for a basic TCP
 * session.
 * <p>
 * The outcome of this exercise will be to return the correct state of the TCP FSM based on the
 * array of events given.
 * <p>
 * The input array of events will consist of one or more of the following strings:
 * <p>
 * APP_PASSIVE_OPEN, APP_ACTIVE_OPEN, APP_SEND, APP_CLOSE, APP_TIMEOUT, RCV_SYN, RCV_ACK,
 * RCV_SYN_ACK, RCV_FIN, RCV_FIN_ACK The states are as follows and should be returned in all capital
 * letters as shown:
 * <p>
 * CLOSED, LISTEN, SYN_SENT, SYN_RCVD, ESTABLISHED, CLOSE_WAIT, LAST_ACK, FIN_WAIT_1, FIN_WAIT_2,
 * CLOSING, TIME_WAIT The input will be an array of events. Your job is to traverse the FSM as
 * determined by the events, and return the proper state as a string, all caps, as shown above.
 * <p>
 * If an event is not applicable to the current state, your code will return "ERROR".
 * <p>
 * Action of each event upon each state: (the format is INITIAL_STATE: EVENT -> NEW_STATE)
 * <p>
 * CLOSED: APP_PASSIVE_OPEN -> LISTEN CLOSED: APP_ACTIVE_OPEN  -> SYN_SENT LISTEN: RCV_SYN
 * -> SYN_RCVD LISTEN: APP_SEND         -> SYN_SENT LISTEN: APP_CLOSE        -> CLOSED SYN_RCVD:
 * APP_CLOSE      -> FIN_WAIT_1 SYN_RCVD: RCV_ACK        -> ESTABLISHED SYN_SENT: RCV_SYN        ->
 * SYN_RCVD SYN_SENT: RCV_SYN_ACK    -> ESTABLISHED SYN_SENT: APP_CLOSE      -> CLOSED ESTABLISHED:
 * APP_CLOSE   -> FIN_WAIT_1 ESTABLISHED: RCV_FIN     -> CLOSE_WAIT FIN_WAIT_1: RCV_FIN      ->
 * CLOSING FIN_WAIT_1: RCV_FIN_ACK  -> TIME_WAIT FIN_WAIT_1: RCV_ACK      -> FIN_WAIT_2 CLOSING:
 * RCV_ACK         -> TIME_WAIT FIN_WAIT_2: RCV_FIN      -> TIME_WAIT TIME_WAIT: APP_TIMEOUT   ->
 * CLOSED CLOSE_WAIT: APP_CLOSE    -> LAST_ACK LAST_ACK: RCV_ACK        -> CLOSED "EFSM TCP"
 * <p>
 * Examples ["APP_PASSIVE_OPEN", "APP_SEND", "RCV_SYN_ACK"] =>  "ESTABLISHED"
 * <p>
 * ["APP_ACTIVE_OPEN"] =>  "SYN_SENT"
 * <p>
 * ["APP_ACTIVE_OPEN", "RCV_SYN_ACK", "APP_CLOSE", "RCV_FIN_ACK", "RCV_ACK"] =>  "ERROR" This kata
 * is similar to Design a Simple Automaton (Finite State Machine), and you may wish to try that kata
 * before tackling this one.
 * <p>
 * See wikipedia page Transmission Control Protocol for further details.
 * <p>
 * See http://www.medianet.kent.edu/techreports/TR2005-07-22-tcp-EFSM.pdf page 4, for the FSM
 * diagram used for this kata.
 * <p>
 * https://www.codewars.com/kata/54acc128329e634e9a000362/train/java
 */
public class TCPFiniteStateMachine {

  private static Map<String, Map<String, String>> statesEventsMapping = new HashMap<>();

  static {

    Map<String, String> closedStateEvents = new HashMap<>();
    closedStateEvents.put("APP_PASSIVE_OPEN", "LISTEN");
    closedStateEvents.put("APP_ACTIVE_OPEN", "SYN_SENT");
    statesEventsMapping.put("CLOSED", closedStateEvents);

    Map<String, String> listenStateEvents = new HashMap<>();
    listenStateEvents.put("RCV_SYN", "SYN_RCVD");
    listenStateEvents.put("APP_SEND", "SYN_SENT");
    listenStateEvents.put("APP_CLOSE", "CLOSED");
    statesEventsMapping.put("LISTEN", listenStateEvents);

    Map<String, String> synRcvdStateEvents = new HashMap<>();
    synRcvdStateEvents.put("APP_CLOSE", "FIN_WAIT_1");
    synRcvdStateEvents.put("RCV_ACK", "ESTABLISHED");
    statesEventsMapping.put("SYN_RCVD", synRcvdStateEvents);

    Map<String, String> synSentStateEvents = new HashMap<>();
    synSentStateEvents.put("RCV_SYN", "SYN_RCVD");
    synSentStateEvents.put("RCV_SYN_ACK", "ESTABLISHED");
    synSentStateEvents.put("APP_CLOSE", "CLOSED");
    statesEventsMapping.put("SYN_SENT", synSentStateEvents);

    Map<String, String> establishedStateEvents = new HashMap<>();
    establishedStateEvents.put("APP_CLOSE", "FIN_WAIT_1");
    establishedStateEvents.put("RCV_FIN", "CLOSE_WAIT");
    statesEventsMapping.put("ESTABLISHED", establishedStateEvents);

    Map<String, String> finWait1StateEvents = new HashMap<>();
    finWait1StateEvents.put("RCV_FIN", "CLOSING");
    finWait1StateEvents.put("RCV_FIN_ACK", "TIME_WAIT");
    finWait1StateEvents.put("RCV_ACK", "FIN_WAIT_2");
    statesEventsMapping.put("FIN_WAIT_1", finWait1StateEvents);

    Map<String, String> closingStateEvents = new HashMap<>();
    closingStateEvents.put("RCV_ACK", "TIME_WAIT");
    statesEventsMapping.put("CLOSING", closingStateEvents);

    Map<String, String> finWait2StateEvents = new HashMap<>();
    finWait2StateEvents.put("RCV_FIN", "TIME_WAIT");
    statesEventsMapping.put("FIN_WAIT_2", finWait2StateEvents);

    Map<String, String> timeWaitStateEvents = new HashMap<>();
    timeWaitStateEvents.put("APP_TIMEOUT", "CLOSED");
    statesEventsMapping.put("TIME_WAIT", timeWaitStateEvents);

    Map<String, String> closeWaitStateEvents = new HashMap<>();
    closeWaitStateEvents.put("APP_CLOSE", "LAST_ACK");
    statesEventsMapping.put("CLOSE_WAIT", closeWaitStateEvents);

    Map<String, String> lastAckStateEvents = new HashMap<>();
    lastAckStateEvents.put("RCV_ACK", "CLOSED");
    statesEventsMapping.put("LAST_ACK", lastAckStateEvents);

  }


  public static String traverseStates(String[] events) {
    String state = "CLOSED";                          // initial state, always
    for (String event : events) {
      Map<String, String> currentStateEvents = statesEventsMapping.get(state);
      System.out.print(currentStateEvents);
      if (!currentStateEvents.containsKey(event)) {
        return "ERROR";
      } else {
        state = statesEventsMapping.get(state).get(event);
      }
    }
    return state;
  }

  public static String traverseStatesShort(String[] events) {
    String state = "CLOSED";
    for (String event : events) {
      state = statesEventsMapping.get(state).get(event);
      if (state == null) return "ERROR";
    }
    return state;
  }
}
