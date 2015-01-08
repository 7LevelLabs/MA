package ua.ll7.slot7.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ll7.slot7.ma.model.CurrencyRate;

import java.util.List;

/**
 * @author velichko
 *         on 08.01.15 : 14:03
 */
public interface ICurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {

  @Query("select cr from CurrencyRate cr where cr.currencyCode1 = ?1 and cr.currencyCode2 = ?2 order by cr.registered desc")
  public List<CurrencyRate> getCurrencyRates(String c1, String c2);
}
