package pl.coderslab.beskidyenduranceproject.service;

import javastrava.api.API;
import javastrava.api.AuthorisationAPI;
import javastrava.auth.model.Token;
import javastrava.auth.model.TokenResponse;
import javastrava.model.StravaActivity;
import javastrava.model.StravaAthlete;
import javastrava.model.StravaStatistics;
import pl.coderslab.beskidyenduranceproject.entity.User;

public class StravaApiService {

    private AuthorisationAPI auth = API.authorisationInstance();

    public StravaAthlete getStravaAthlete(User user)  {

        TokenResponse resposne = auth.tokenExchange(user.getStravaClientId(), user.getStravaClientSecret(), user.getStravaCode());
        Token token  = new Token(resposne);
        API api = new API(token);
        StravaAthlete athlete = api.getAthlete(10147971);
        return athlete;

}
    public StravaStatistics getAthleteStatistic(User user) {

        TokenResponse resposne = auth.tokenExchange(user.getStravaClientId(), user.getStravaClientSecret(), user.getStravaCode());
        Token token  = new Token(resposne);
        API api = new API(token);
        StravaStatistics statistics = api.statistics(10147971);
        return statistics;
    }

    public StravaActivity getActivity(User user, Long id) {

        TokenResponse resposne = auth.tokenExchange(user.getStravaClientId(), user.getStravaClientSecret(), user.getStravaCode());
        Token token  = new Token(resposne);
        API api = new API(token);
        StravaActivity activity = api.getActivity(id, true);
        return activity;
    }

}
