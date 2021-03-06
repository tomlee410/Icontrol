/*
 * This software was developed at the National Institute of Standards and
 * Technology by a guest researcher in the course of his official duties and
 * with the partial support of the Swiss National Science Foundation. Pursuant
 * to title 17 Section 105 of the United States Code this software is not
 * subject to copyright protection and is in the public domain. The
 * Instrument-Control (iC) software is an experimental system. Neither NIST, nor
 * the Swiss National Science Foundation nor any of the authors assumes any
 * responsibility whatsoever for its use by other parties, and makes no
 * guarantees, expressed or implied, about its quality, reliability, or any
 * other characteristic. We would appreciate your citation if the software
 * is used: http://dx.doi.org/10.6028/jres.117.010 .
 *
 * This software can be redistributed and/or modified freely under the terms of
 * the GNU Public Licence and provided that any derivative works bear some
 * notice that they are derived from it, and any modified versions bear some
 * notice that they have been modified.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Public License for more details. http://www.fsf.org
 *
 * This software relies on other open source projects; please see the accompanying
 * _ReadMe_iC.txt for a list of included packages. Thank's very much to those
 * developers !! Without your effort, iC would not have been possible!
 *
 */
//http://download.oracle.com/javase/tutorial/uiswing/components/dialog.html
//http://download.oracle.com/javase/tutorial/uiswing/components/frame.html#windowevents
//http://download.oracle.com/javase/tutorial/uiswing/components/dialog.html
package icontrol.dialogs;

import icontrol.GUI_Interface;
import icontrol.iC_Properties;
import icontrol.Utilities;
import java.awt.Toolkit;
import java.util.logging.Logger;
import org.jdesktop.application.Action;

/**
 * This class presents a <code>JDialog</code> to the user after an invalid response
 * to an *IDN query was received. It presents the user with 4 choices, namely to
 * stop scripting, to switch to No-Communication Mode, to accept the Instrument's
 * response once or to store it in the User properties. After instantiating this
 * class, a call to <code>AskUser</code> shows the modal dialog and returns with
 * the answer of the user as defined in the <code>ACTION_...</code> constants.
 *
 *
 * @author KPP (Kurt Pernstich: pernstich@alumni.ethz.ch)
 * @version 0.3
 */
public class WrongIDN extends javax.swing.JDialog {

    ///////////////////
    // define constants
    public final int ACTION_STOP = 1;
    public final int ACTION_NO_COMMUNICATION = 2;
    public final int ACTION_ACCEPT = 3;


    ///////////////////
    // member variables
    String          m_InstrumentResonse;
    String          m_ExpectedResponse;
    String          m_ClassName;
    iC_Properties   m_iC_Properties;

    /** The Logger for this class */
    private static final Logger m_Logger = Logger.getLogger("iC.Dialogs.WrongIDN");

    /**
     * Holds a reference to the <code>IcontrolView</code> class. Using getView 
     * to get a handle to the View (to use DisplayStatusMessage etc.) was introduced 
     * with JUnit tests on 120727 (v1.3.469).
     */
    protected static final GUI_Interface m_GUI = Utilities.getView();


    /** 
     * Creates new form WrongIDN and initializes the fields
     */
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public WrongIDN(java.awt.Frame parent,
                    String Message, 
                    String InstrumentResponse,
                    String ExpectedResponse,
                    String ClassName) {

        // always make it a modal dialog
        super(parent, true);
        initComponents();

        // set Logger level to inherit level of parent logger
        m_Logger.setLevel(null);

        // init member variables
        m_ClassName = ClassName;
        m_InstrumentResonse = InstrumentResponse;
        m_ExpectedResponse = ExpectedResponse;

        // init my components
        jTextArea.setText(Message);
        jNewResponse.setText(InstrumentResponse);
        jRB_NoComm.setSelected(true);

        // instantiate iC_Properties
        m_iC_Properties = new iC_Properties();
    }//</editor-fold>

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioButtons = new javax.swing.ButtonGroup();
        jRB_Stop = new javax.swing.JRadioButton();
        jRB_NoComm = new javax.swing.JRadioButton();
        jNewResponse = new javax.swing.JTextField();
        jSelectOption = new javax.swing.JButton();
        jRB_AcceptOnce = new javax.swing.JRadioButton();
        jRB_AcceptPermanently = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        RadioButtons.add(jRB_Stop);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(icontrol.IcontrolApp.class).getContext().getResourceMap(WrongIDN.class);
        jRB_Stop.setText(resourceMap.getString("jRB_Stop.text")); // NOI18N
        jRB_Stop.setName("jRB_Stop"); // NOI18N

        RadioButtons.add(jRB_NoComm);
        jRB_NoComm.setText(resourceMap.getString("jRB_NoComm.text")); // NOI18N
        jRB_NoComm.setName("jRB_NoComm"); // NOI18N

        jNewResponse.setToolTipText(resourceMap.getString("jNewResponse.toolTipText")); // NOI18N
        jNewResponse.setName("jNewResponse"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(icontrol.IcontrolApp.class).getContext().getActionMap(WrongIDN.class, this);
        jSelectOption.setAction(actionMap.get("SelectOption")); // NOI18N
        jSelectOption.setText(resourceMap.getString("jSelectOption.text")); // NOI18N
        jSelectOption.setName("jSelectOption"); // NOI18N

        RadioButtons.add(jRB_AcceptOnce);
        jRB_AcceptOnce.setSelected(true);
        jRB_AcceptOnce.setText(resourceMap.getString("jRB_AcceptOnce.text")); // NOI18N
        jRB_AcceptOnce.setName("jRB_AcceptOnce"); // NOI18N

        RadioButtons.add(jRB_AcceptPermanently);
        jRB_AcceptPermanently.setText(resourceMap.getString("jRB_AcceptPermanently.text")); // NOI18N
        jRB_AcceptPermanently.setToolTipText(resourceMap.getString("jRB_AcceptPermanently.toolTipText")); // NOI18N
        jRB_AcceptPermanently.setName("jRB_AcceptPermanently"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea.setColumns(20);
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        jTextArea.setRows(5);
        jTextArea.setName("jTextArea"); // NOI18N
        jScrollPane1.setViewportView(jTextArea);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                    .add(jSelectOption)
                    .add(layout.createSequentialGroup()
                        .add(jRB_AcceptPermanently)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jNewResponse, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                    .add(jRB_AcceptOnce)
                    .add(jRB_NoComm)
                    .add(jRB_Stop)
                    .add(jLabel2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 175, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jRB_Stop)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jRB_NoComm)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jRB_AcceptOnce)
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRB_AcceptPermanently)
                    .add(jNewResponse, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jSelectOption)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   /**
    * Displays the dialog and waits until the User makes a choice or closes
    * the Dialog, in which case the default behavior (<code>ACTION_STOP</code>)
    * will be selected.<p>
    *
    * If the user selected to accept the Instrument response to a *IDN? query
    * permanently, the appropriate entry in the iC.properties is updated.<p>
    *
    * @return The value of the action the user has selected. The values are
    * defined in the constants, for instance <code>ACTION_ACCEPT</code>.
    */
    // <editor-fold defaultstate="collapsed" desc="Ask User">
    public int AskUser() {

        // add a new Window Listener that reacts on closing the window
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                // chose default action
                jRB_Stop.setSelected(true);

                // hide the frame. this causes this.setVisible to return
                setVisible(false);
            }
        });

        // show the dialog and wait until it is closed
        this.setVisible(true);


        ////////////////////////////////
        // try to set the new IDN string
        // if Accept Permanently was selected

        // get class name without package
        String iCKey = m_ClassName ;
        iCKey = iCKey.substring( iCKey.lastIndexOf ('.') + 1 );

        // add the second part of the key
        iCKey += ".InstrumentNameIdentifier";

        // try to get the Instrument Response
        String iCEntry = m_iC_Properties.getString(iCKey, "");


        // User selected to update User properties.
        // The Instrument's response passed to this object is the same as was found
        // when using the standard InstrumentNameIdentifier (ClassName.InstrumentNameIdentifier)
        // in the defualt/user properties, so the key is right, hence, accept the
        // new Instrument response
        if ( jRB_AcceptPermanently.isSelected() ) {
             if (iCEntry.equalsIgnoreCase(m_ExpectedResponse)) {
                // yes, so set the new entry
                m_iC_Properties.setString(iCKey, jNewResponse.getText());
            } else {
                 // Show message to the user
                String str = "Warning: Could not store the new Instrument's response in the User properties,\n"
                        + "possibly because a non-conform getInstrumentNameIdentifier().\n";
                m_GUI.DisplayStatusMessage(str, false);

                // log event
                m_Logger.warning(str);

                // beep
                Toolkit.getDefaultToolkit().beep();
            }
        }


        // return the value of the selected Radio Button
        if (jRB_NoComm.isSelected()) {
            // log selection
            m_Logger.fine("User selected No-Communication-Mode\n");

            return ACTION_NO_COMMUNICATION;
        } else if (jRB_AcceptOnce.isSelected() ||
                   jRB_AcceptPermanently.isSelected()) {
            // log selection
            m_Logger.fine("User selected to accept the response\n");

            return ACTION_ACCEPT;
        } else {
            // log selection
            m_Logger.fine("User selected to stop scripting\n");

            return ACTION_STOP;
        }


        // one could also use the following construct (see DialogDemo.java)
        //radioButton.setActionCommand( some String );
        //showItButton.addActionListener(new ActionListener() {
        //    public void actionPerformed(ActionEvent e) {
        //        String command = group.getSelection().getActionCommand();
        //        if (command == defaultMessageCommand) { ... }
    }//</editor-fold>


    /**
     * Action which is executed when the user presses the 'Select Option' button.
     */
    // <editor-fold defaultstate="collapsed" desc="Select Option">
    @Action
    public void SelectOption() {
        // just close the Frame
        // This will cause setVisible() in AskUser() to return
        setVisible(false);
    }//</editor-fold>




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RadioButtons;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jNewResponse;
    private javax.swing.JRadioButton jRB_AcceptOnce;
    private javax.swing.JRadioButton jRB_AcceptPermanently;
    private javax.swing.JRadioButton jRB_NoComm;
    private javax.swing.JRadioButton jRB_Stop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSelectOption;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables

}
