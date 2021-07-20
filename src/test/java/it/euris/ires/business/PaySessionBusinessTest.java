package it.euris.ires.business;

import it.euris.ires.dataObject.CreatePaySessionRequest;
import it.euris.ires.dataObject.CreatePaySessionResponse;
import it.euris.ires.entity.PaySession;
import it.euris.ires.exception.PaySessionException;
import it.euris.ires.service.IPaymentSessionService;
import it.euris.ires.util.PaySessionStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.assertj.core.api.BDDAssumptions.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)

public class PaySessionBusinessTest {
    PaySessionBusiness paySessionBusiness;

    @Mock
    IPaymentSessionService spyPaymentSessionService;

   // @Mock
   // CreatePaySessionRequest stubRequest;

   // @Spy
    //CreatePaySessionResponse spyCreatePaymentResponse;

    @BeforeEach
    void setUp(){
        paySessionBusiness = new PaySessionBusiness(spyPaymentSessionService);
    }

//si vuole testare il metodo createPaySession che prende in input l'oggetto di classe CreatePaySessionRequest
    @Test
    void givenRequestWhenCreatePaySessionThenReturnCreatePaySessionResponse() throws PaySessionException {
        //arrange
        //stubRequest = new CreatePaySessionRequest();
        //PaySession paySession = spyPaymentSessionService.createWebPaySession(stubRequest);
        CreatePaySessionRequest request = new CreatePaySessionRequest();
        PaySession paySession = new PaySession();
        paySession.setStatus(PaySessionStatus.PAID);
        //CreatePaySessionResponse expectedResponse = new CreatePaySessionResponse();
        //expectedResponse.setSuccess(true);
        //expectedResponse.setStatus(PaySessionStatus.PAID.toString());
        //expectedResponse.setPaySessionId(paySession.getUuid().toString());

        //act
        //spyCreatePaymentResponse = paySessionBusiness.createPaySession(stubRequest);

        given(spyPaymentSessionService.createWebPaySession(request)).willReturn(paySession);
        //assert
       CreatePaySessionResponse response = paySessionBusiness.createPaySession(request);

       assertThat(response.getPaySessionId()).isEqualTo(paySession.getUuid().toString());
    }
}
