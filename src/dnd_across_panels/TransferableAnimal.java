/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd_across_panels;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author pauloarthur
 */
class TransferableAnimal implements Transferable {

		private Animal animal;
                DataFlavor dataFlavor = new DataFlavor(Animal.class,
			Animal.class.getSimpleName());


		public TransferableAnimal(Animal ani) {
			this.animal = ani;
		}

		@Override
		public DataFlavor[] getTransferDataFlavors() {
			return new DataFlavor[] { dataFlavor };
		}

		@Override
		public boolean isDataFlavorSupported(DataFlavor flavor) {
			return flavor.equals(dataFlavor);
		}

		@Override
		public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {

			if (flavor.equals(dataFlavor))
				return animal;
			else
				throw new UnsupportedFlavorException(flavor);
		}
	}