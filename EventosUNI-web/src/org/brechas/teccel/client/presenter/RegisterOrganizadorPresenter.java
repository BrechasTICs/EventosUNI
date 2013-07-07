package org.brechas.teccel.client.presenter;

import java.util.ArrayList;

import org.brechas.teccel.client.place.NameTokens;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class RegisterOrganizadorPresenter
		extends
		Presenter<RegisterOrganizadorPresenter.MyView, RegisterOrganizadorPresenter.MyProxy> {

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Contacto = new Type<RevealContentHandler<?>>();
	private ArrayList <Integer> listtel = new ArrayList<Integer>();
	private ArrayList <Integer> listdir = new ArrayList<Integer>();
	private ArrayList <Integer> listema = new ArrayList<Integer>();
	private ArrayList <Integer> listpag = new ArrayList<Integer>();
	
	public interface MyView extends View {
		public TextBox getNombre();

		public TextArea getDescripcion();

		public HTMLPanel getPanelContacto();

		public FlexTable getTelefono();

		public FlexTable getDireccion();

		public FlexTable getEmail();

		public FlexTable getPaginaweb();

		public Button getMasTelefono();

		public Button getMasDireccion();

		public Button getMasEmail();

		public Button getMasPaginaweb();

		public Button getMenosTelefono();

		public Button getMenosDireccion();

		public Button getMenosEmail();

		public Button getMenosPaginaweb();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.registerorganizador)
	public interface MyProxy extends ProxyPlace<RegisterOrganizadorPresenter> {
	}

	@Inject
	public RegisterOrganizadorPresenter(final EventBus eventBus,
			final MyView view, final MyProxy proxy,
			Provider<WidgetContactoPresenter> providerContacto) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent
				.fire(this, LayoutPresenter.SLOT_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().getMasDireccion().addClickHandler(agregarDireccionHandler);
		getView().getMasEmail().addClickHandler(agregarEmailHandler);
		getView().getMasPaginaweb().addClickHandler(agregarPaginawebHandler);
		getView().getMasTelefono().addClickHandler(agregarTelefonoHandler);
	}

	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset() {
		super.onReset();
		int row = 0;
		getView().getTelefono().setWidget(row, 0, new Label("Telefono "));
		getView().getTelefono().setWidget(row, 1, new TextBox());
		getView().getTelefono().setWidget(row, 2, getView().getMasTelefono());
		getView().getDireccion().setWidget(row, 0, new Label("Direccion "));
		getView().getDireccion().setWidget(row, 1, new TextBox());
		getView().getDireccion().setWidget(row, 2, getView().getMasDireccion());
		getView().getEmail().setWidget(row, 0, new Label("Email "));
		getView().getEmail().setWidget(row, 1, new TextBox());
		getView().getEmail().setWidget(row, 2, getView().getMasEmail());
		getView().getPaginaweb().setWidget(row, 0, new Label("Pagina Web "));
		getView().getPaginaweb().setWidget(row, 1, new TextBox());
		getView().getPaginaweb().setWidget(row, 2, getView().getMasPaginaweb());
	}
	ClickHandler agregarTelefonoHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {int row = getView().getTelefono().getRowCount();
		getView().getTelefono().setWidget(row, 0, new Label("Telefono "));
		getView().getTelefono().setWidget(row, 1, new TextBox());
		Button but =new Button("x");
		final int rowb= new Integer(Random.nextInt());
		listtel.add(rowb);
		but.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				int removeIndex = listtel.indexOf(rowb);
				listtel.remove(removeIndex);
				getView().getTelefono().removeRow(removeIndex+1);
			}
		});
		getView().getTelefono().setWidget(row, 2, but);
		}
	};
	ClickHandler agregarDireccionHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {int row = getView().getDireccion().getRowCount();
		getView().getDireccion().setWidget(row, 0, new Label("Direccion "));
		getView().getDireccion().setWidget(row, 1, new TextBox());
		Button but =new Button("x");
		final int rowb= new Integer(Random.nextInt());
		listdir.add(rowb);
		but.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				int removeIndex = listdir.indexOf(rowb);
				listdir.remove(removeIndex);
				getView().getDireccion().removeRow(removeIndex+1);
			}
		});
		getView().getDireccion().setWidget(row, 2, but);
		}
	};
	ClickHandler agregarEmailHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {int row = getView().getEmail().getRowCount();
		getView().getEmail().setWidget(row, 0, new Label("Email "));
		getView().getEmail().setWidget(row, 1, new TextBox());
		Button but =new Button("x");
		final int rowb= new Integer(Random.nextInt());
		listema.add(rowb);
		but.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				int removeIndex = listema.indexOf(rowb);
				listema.remove(removeIndex);
				getView().getEmail().removeRow(removeIndex+1);
			}
		});
		getView().getEmail().setWidget(row, 2, but);
		}
	};
	ClickHandler agregarPaginawebHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {int row = getView().getPaginaweb().getRowCount();
		getView().getPaginaweb().setWidget(row, 0, new Label("Pagina Web "));
		getView().getPaginaweb().setWidget(row, 1, new TextBox());
		Button but =new Button("x");
		final int rowb= new Integer(Random.nextInt());
		listpag.add(rowb);
		but.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				int removeIndex = listpag.indexOf(rowb);
				listpag.remove(removeIndex);
				getView().getPaginaweb().removeRow(removeIndex+1);
			}
		});
		getView().getPaginaweb().setWidget(row, 2, but);
		}
	};
}
