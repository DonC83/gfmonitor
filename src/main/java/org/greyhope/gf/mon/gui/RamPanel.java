package org.greyhope.gf.mon.gui;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Theme.Category;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import org.greyhope.gf.mon.framework.FeatureEvent;
import org.greyhope.gf.mon.framework.MemoryFeatureListener;
import org.greyhope.gf.mon.tree.Memory;
import org.greyhope.gf.mon.utils.Functions;

/**
 *
 * @author greyhope
 */
public class RamPanel extends Panel implements MemoryFeatureListener{
    
    Label ramAlloc;
    Label ramUsed;
    Label ramFree;
    
    Memory memory;
    
    public RamPanel(){
      super("Heap RAM (MB)",new Border.Bevel(true), Panel.Orientation.HORISONTAL);
      
      TerminalSize size = new TerminalSize(51,3);
      this.setPreferredSize(size);
      
      // Set the Host Label
      addComponent(new Label("Allocated : ", Terminal.Color.BLACK, true));
      ramAlloc = new Label("",4);
      ramAlloc.setStyle(Category.TEXTBOX);
      addComponent(ramAlloc);
      
      // Set the Port Label 
      addComponent(new Label("Used : ", Terminal.Color.BLACK, true));
      ramUsed = new Label("",4);
      ramUsed.setStyle(Category.TEXTBOX);
      addComponent(ramUsed);
      
      // Set the Port Label 
      addComponent(new Label("Free : ", Terminal.Color.BLACK, true));
      ramFree = new Label("",4);
      ramFree.setStyle(Category.TEXTBOX);
      addComponent(ramFree);
      
    }

    @Override
    public void featureChanged(FeatureEvent obj) {
        
        memory = (Memory) obj.getFeature();
        
        String mbAllocated = String.valueOf(Functions.bytesToMb(memory.get_maxheapsize_count().get_count()));
        String mbUsed = String.valueOf(Functions.bytesToMb(memory.get_usedheapsize_count().get_count()));
        String mbFree = String.valueOf(Functions.getUnusedRamAmount(memory.get_maxheapsize_count().get_count(), memory.get_usedheapsize_count().get_count()));
        
        //System.out.println("RAM Allocated : " + mbAllocated);
        
        ramAlloc.setText(mbAllocated);
        ramUsed.setText(mbUsed);
        ramFree.setText(mbFree);
        
    }
}
