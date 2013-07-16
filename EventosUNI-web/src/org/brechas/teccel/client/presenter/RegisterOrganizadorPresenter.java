package org.brechas.teccel.client.presenter;

import java.util.ArrayList;

import org.brechas.teccel.client.action.BlobStoreUrl;
import org.brechas.teccel.client.action.BlobStoreUrlResult;
import org.brechas.teccel.client.action.RegisterOrganizador;
import org.brechas.teccel.client.action.RegisterOrganizadorResult;
import org.brechas.teccel.client.event.EmailEvent;
import org.brechas.teccel.client.event.EmailEvent.EmailHandler;
import org.brechas.teccel.client.place.NameTokens;
import org.brechas.teccel.shared.entity.ContactoDto;
import org.brechas.teccel.shared.entity.OrganizadorDto;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class RegisterOrganizadorPresenter
		extends
		Presenter<RegisterOrganizadorPresenter.MyView, RegisterOrganizadorPresenter.MyProxy>
		implements EmailHandler {

	private ArrayList<Integer> listtel;
	private ArrayList<Integer> listdir;
	private ArrayList<Integer> listema;
	private ArrayList<Integer> listpag;
	private EventBus eventBus;
	private String email;

	public interface MyView extends View {
		public FormPanel getUploadForm();

		public TextBox getAcronimo();

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

		public Button getRegistrar();

		public FileUpload getLogo();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.registerorganizador)
	public interface MyProxy extends ProxyPlace<RegisterOrganizadorPresenter> {
	}

	@Inject
	DispatchAsync dispatchAsync;
	@Inject
	RegisterOrganizador regOrganizador;
	@Inject
	BlobStoreUrl blobStoreUrl;

	@Inject
	public RegisterOrganizadorPresenter(final EventBus eventBus,
			final MyView view, final MyProxy proxy) {
		super(eventBus, view, proxy);
		this.eventBus = eventBus;
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
		getView().getRegistrar().addClickHandler(regHandler);
		addRegisteredHandler(EmailEvent.getType(), this);
	}

	public void onEmail(EmailEvent event) {
		email = event.getEmail();
	}

	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset() {
		super.onReset();
		EmailEvent emailEvent = new EmailEvent();
		int row = 0;
		listtel = new ArrayList<Integer>();
		listdir = new ArrayList<Integer>();
		listema = new ArrayList<Integer>();
		listpag = new ArrayList<Integer>();
		getView().getTelefono().removeAllRows();
		getView().getEmail().removeAllRows();
		getView().getDireccion().removeAllRows();
		getView().getPaginaweb().removeAllRows();
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
		getView().getUploadForm().addSubmitCompleteHandler(uploadImageHandler);
		RegisterOrganizadorPresenter.this.eventBus.fireEvent(emailEvent);
	}

	ClickHandler agregarTelefonoHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			int row = getView().getTelefono().getRowCount();
			getView().getTelefono().setWidget(row, 0, new Label("Telefono "));
			getView().getTelefono().setWidget(row, 1, new TextBox());
			Button but = new Button("x");
			final int rowb = new Integer(Random.nextInt());
			listtel.add(rowb);
			but.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					int removeIndex = listtel.indexOf(rowb);
					listtel.remove(removeIndex);
					getView().getTelefono().removeRow(removeIndex + 1);
				}
			});
			getView().getTelefono().setWidget(row, 2, but);
		}
	};
	ClickHandler agregarDireccionHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			int row = getView().getDireccion().getRowCount();
			getView().getDireccion().setWidget(row, 0, new Label("Direccion "));
			getView().getDireccion().setWidget(row, 1, new TextBox());
			Button but = new Button("x");
			final int rowb = new Integer(Random.nextInt());
			listdir.add(rowb);
			but.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					int removeIndex = listdir.indexOf(rowb);
					listdir.remove(removeIndex);
					getView().getDireccion().removeRow(removeIndex + 1);
				}
			});
			getView().getDireccion().setWidget(row, 2, but);
		}
	};
	ClickHandler agregarEmailHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			int row = getView().getEmail().getRowCount();
			getView().getEmail().setWidget(row, 0, new Label("Email "));
			getView().getEmail().setWidget(row, 1, new TextBox());
			Button but = new Button("x");
			final int rowb = new Integer(Random.nextInt());
			listema.add(rowb);
			but.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					int removeIndex = listema.indexOf(rowb);
					listema.remove(removeIndex);
					getView().getEmail().removeRow(removeIndex + 1);
				}
			});
			getView().getEmail().setWidget(row, 2, but);
		}
	};
	ClickHandler agregarPaginawebHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			int row = getView().getPaginaweb().getRowCount();
			getView().getPaginaweb()
					.setWidget(row, 0, new Label("Pagina Web "));
			getView().getPaginaweb().setWidget(row, 1, new TextBox());
			Button but = new Button("x");
			final int rowb = new Integer(Random.nextInt());
			listpag.add(rowb);
			but.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					int removeIndex = listpag.indexOf(rowb);
					listpag.remove(removeIndex);
					getView().getPaginaweb().removeRow(removeIndex + 1);
				}
			});
			getView().getPaginaweb().setWidget(row, 2, but);
		}
	};
	ClickHandler regHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			int i;
			ContactoDto con;
			regOrganizador.setRequest(email);
			regOrganizador.setOrganizador(new OrganizadorDto());
			regOrganizador.getOrganizador().setDescripcion(
					getView().getDescripcion().getValue());
			regOrganizador.getOrganizador().setNombre(
					getView().getNombre().getText());
			regOrganizador.getOrganizador().setAcronimo(
					getView().getAcronimo().getText());
			for (i = 0; i < getView().getTelefono().getRowCount(); i++) {
				String val = ((TextBox) getView().getTelefono().getWidget(i, 1))
						.getText();
				if (!val.trim().equals("")) {
					con = new ContactoDto();
					con.setTipo("Telefono");
					con.setValor(val);
					regOrganizador.getListContacto().add(con);
				}
			}
			for (i = 0; i < getView().getDireccion().getRowCount(); i++) {
				String val = ((TextBox) getView().getDireccion()
						.getWidget(i, 1)).getText();
				if (!val.trim().equals("")) {
					con = new ContactoDto();
					con.setTipo("Direccion");
					con.setValor(val);
					regOrganizador.getListContacto().add(con);
				}
			}
			for (i = 0; i < getView().getEmail().getRowCount(); i++) {
				String val = ((TextBox) getView().getEmail().getWidget(i, 1))
						.getText();
				if (!val.trim().equals("")) {
					con = new ContactoDto();
					con.setTipo("Email");
					con.setValor(val);
					regOrganizador.getListContacto().add(con);
				}
			}
			for (i = 0; i < getView().getPaginaweb().getRowCount(); i++) {
				String val = ((TextBox) getView().getPaginaweb()
						.getWidget(i, 1)).getText();
				if (!val.trim().equals("")) {
					con = new ContactoDto();
					con.setTipo("Pagina Web");
					con.setValor(val);
					regOrganizador.getListContacto().add(con);
				}
			}
			dispatchAsync.execute(regOrganizador, registerActionCallback);
		}
	};
	SubmitCompleteHandler uploadImageHandler = new FormPanel.SubmitCompleteHandler() {

		@Override
		public void onSubmitComplete(SubmitCompleteEvent event) {
			Window.alert("Gooood!");
			// String key = event.getResults();
		}
	};
	private AsyncCallback<RegisterOrganizadorResult> registerActionCallback = new AsyncCallback<RegisterOrganizadorResult>() {
		public void onFailure(Throwable caught) {

			Window.alert("Error Data: " + caught.getMessage());
		};

		public void onSuccess(RegisterOrganizadorResult result) {
			Window.alert("Bien! Organizador Registrado");
			dispatchAsync.execute(blobStoreUrl, blobStoreUrlCallback);
		}
	};
	private AsyncCallback<BlobStoreUrlResult> blobStoreUrlCallback = new AsyncCallback<BlobStoreUrlResult>() {
		public void onFailure(Throwable caught) {
			Window.alert("Error Blob: " + caught.getMessage());
		};

		public void onSuccess(BlobStoreUrlResult result) {
			getView().getUploadForm().setAction(result.getUploadUrl());
			getView().getUploadForm().setEncoding(FormPanel.ENCODING_MULTIPART);
			getView().getUploadForm().setMethod(FormPanel.METHOD_POST);
			getView().getUploadForm().submit();
		}
	};

}
