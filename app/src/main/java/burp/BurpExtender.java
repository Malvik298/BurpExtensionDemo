package burp;

import java.io.PrintWriter;

/**
 *
 * @author malvik
 */
public class BurpExtender implements IBurpExtender, IExtensionStateListener  {

    IBurpExtenderCallbacks callbacks;
    IExtensionHelpers helpers;
    PrintWriter stdout ;
    PrintWriter stderr ;
    
    
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        
        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        stdout = new PrintWriter(callbacks.getStdout(), true); //for normal console output
        stderr = new PrintWriter(callbacks.getStderr(), true); // for error console output
        
        //Set name for extension
        callbacks.setExtensionName("Custom Burp");
        
        callbacks.registerExtensionStateListener(BurpExtender.this);
        
        stdout.println("Extension Loaded");
    }

    @Override
    public void extensionUnloaded() {
        //action to perform when extension is unloaded  
        stdout.println("Extension Unloaded");
        
    }

    
    
    
}
