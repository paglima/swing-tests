/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd_across_panels;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import javax.swing.JPanel;

/**
 *
 * @author pauloarthur
 */
public class MyDropTargetListImp extends DropTargetAdapter implements DropTargetListener {

		private DropTarget dropTarget;
		private JPanel panel;
                DataFlavor dataFlavor = new DataFlavor(Animal.class,Animal.class.getSimpleName());


		public MyDropTargetListImp(JPanel panel) {
			this.panel = panel;

			dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this,
					true, null);
		}

		public void drop(DropTargetDropEvent event) {
			try {
				Transferable tr = event.getTransferable();
				Animal an = (Animal) tr.getTransferData(dataFlavor);

				if (event.isDataFlavorSupported(dataFlavor)) {
					event.acceptDrop(DnDConstants.ACTION_COPY);
					this.panel.add(new JLabelAnimal(an));
					event.dropComplete(true);
					this.panel.validate();
					return;
				}
				event.rejectDrop();
			} catch (Exception e) {
				e.printStackTrace();
				event.rejectDrop();
			}
		}
                
}
