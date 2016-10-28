package ru.icm.cft.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ListBox;
import java.util.ArrayList;
import java.util.List;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;


/**
 * Created by artem on 28.09.2016.
 */
public class TestPage extends Composite {
    
    interface TestPageUiBinder extends UiBinder<HTMLPanel, TestPage> {
    }

    private TestPageUiBinder ourUiBinder = GWT.create(TestPageUiBinder.class);
    private final CountryService countryService = GWT.create(CountryService.class);
    private final CityService cityService = GWT.create(CityService.class);
    private final UnitService unitService = GWT.create(UnitService.class);
    private final ArrayList unitList = new ArrayList<>();;
    
    @UiField
    CellTable<Unit> unitCellTable;

    @UiField
    ListBox countryLB;

    @UiField
    ListBox cityLB;

    public TestPage() {
        initWidget(ourUiBinder.createAndBindUi(this));
        
        countryService.getCountries(new MethodCallback<List<Country>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                GWT.log("Error on country service:" + exception.getMessage() + "\n");
            }

            @Override
            public void onSuccess(Method method, List<Country> response) {
                for(Country c : response){
                    GWT.log("Get from country service: " + response.toString() + "\n");
                    countryLB.addItem(c.getName());
                }
                
                refreshCities(countryLB.getSelectedValue());
            }
        });
        
        countryLB.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                String selectedValue = countryLB.getSelectedItemText();
                
                refreshCities(selectedValue);
            }
        });
        
        cityLB.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                String selectedValue = cityLB.getSelectedItemText();
                refreshTable(selectedValue);
            }

            
        });

        TextColumn<Unit> nameColumn = new TextColumn<Unit>() {
            @Override
            public String getValue(Unit unit) {
                return unit.getBank().getName();
            }
        };
        unitCellTable.addColumn(nameColumn, "Bank Name");

        TextColumn<Unit> addressColumn = new TextColumn<Unit>() {
            @Override
            public String getValue(Unit unit) {
                return unit.getAddress();
            }
        };
        unitCellTable.addColumn(addressColumn, "Address");

        TextColumn<Unit> directionColumn = new TextColumn<Unit>() {
            @Override
            public String getValue(Unit unit) {
                return unit.getDirection();
            }
        };
        unitCellTable.addColumn(directionColumn, "Direction");

    }

    private void refreshCities(final String selectedCountry){
        
        
        if(selectedCountry == null || selectedCountry.equals(""))
            return;
        
        cityService.getCitiesByCountryName(selectedCountry, new MethodCallback<List<City>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
            }

            @Override
            public void onSuccess(Method method, List<City> response) {
                cityLB.clear();
                for(City c : response){
                    if(c.getCountry().getName().equals(selectedCountry))
                    cityLB.addItem(c.getName());
                }
                
                refreshTable(cityLB.getSelectedItemText());
            }
        });
    }
    
    private void refreshTable(final String selectedCity) {
        
        if(selectedCity == null || selectedCity.equals(""))
            return;
        
        unitService.getUnitsByCityName(selectedCity, new MethodCallback<List<Unit>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
            }

            @Override
            public void onSuccess(Method method, List<Unit> response) {

                unitList.clear();
                for(Unit u : response){
                    if(u.getCity().getName().equals(selectedCity))
                        unitList.add(u);
                }

                unitCellTable.setRowCount(unitList.size(), true);
                unitCellTable.setRowData(0, unitList);
                
            }
        });
        
    }
}