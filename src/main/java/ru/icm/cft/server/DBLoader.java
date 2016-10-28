package ru.icm.cft.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * Created by artem on 22.09.2016.
 */
@Service
@Profile( {"h2", "oracle"})
public class DBLoader {

    private final CountryRepo countryRepo;
    private final CityRepo cityRepo;
    private final BankRepo bankRepo;
    private final UnitRepo unitRepo;

    @Autowired
    public DBLoader(CountryRepo countryRepo, CityRepo cityRepo, BankRepo bankRepo, UnitRepo unitRepo){
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
        this.bankRepo = bankRepo;
        this.unitRepo = unitRepo;
    }

    @PostConstruct
    private void initDB(){
        Country russia = new Country();
        russia.setName("Russia");
        countryRepo.save(russia);

        Country belorussia = new Country();
        belorussia.setName("Belorussia");
        countryRepo.save(belorussia);

        City moscow = new City();
        moscow.setName("Moscow");
        moscow.setCountry(russia);
        cityRepo.save(moscow);

        City piter = new City();
        piter.setName("Piter");
        piter.setCountry(russia);
        cityRepo.save(piter);

        City minsk = new City();
        minsk.setName("Minsk");
        minsk.setCountry(belorussia);
        cityRepo.save(minsk);

        City vitebsk = new City();
        vitebsk.setName("Vitebsk");
        vitebsk.setCountry(belorussia);
        cityRepo.save(vitebsk);

        Bank sber = new Bank();
        sber.setName("Sberbank");
        bankRepo.save(sber);

        Bank alfa = new Bank();
        alfa.setName("Alfabank");
        bankRepo.save(alfa);

        Unit u1 = new Unit();
        u1.setName("First of units");
        u1.setAddress("Poltavskaya 32");
        u1.setDirection("IN");
        u1.setBank(sber);
        u1.setCity(moscow);        
        unitRepo.save(u1);

        Unit u11 = new Unit();
        u11.setName("Alfa 1");
        u11.setAddress("Poltavskaya 12");
        u11.setDirection("OUT");
        u11.setBank(alfa);
        u11.setCity(moscow);        
        unitRepo.save(u11);
        
        Unit u2 = new Unit();
        u2.setName("Second of units");
        u2.setAddress("Mira 1");
        u2.setDirection("IN \\ OUT");
        u2.setBank(sber);
        u2.setCity(moscow);
        unitRepo.save(u2);
        
        Unit u22 = new Unit();
        u22.setName("Alfa 2");
        u22.setAddress("Mira 11");
        u22.setDirection("OUT");
        u22.setBank(alfa);
        u22.setCity(moscow);
        unitRepo.save(u22);
        
        Unit u3 = new Unit();
        u3.setName("Unit name 1");
        u3.setAddress("Novaya 22");
        u3.setDirection("OUT");
        u3.setBank(sber);
        u3.setCity(minsk);
        unitRepo.save(u3);
        
        Unit u4 = new Unit();
        u4.setName("Another unit name");
        u4.setAddress("Shirokaya 18a");
        u4.setDirection("IN");
        u4.setBank(sber);
        u4.setCity(minsk);
        unitRepo.save(u4);

//        List<City> byCountryId = cityRepo.findByCountryId(1);
//        System.out.print(byCountryId.size());
//        
//        unitRepo.findByCityName("Moscow");

    }
}
