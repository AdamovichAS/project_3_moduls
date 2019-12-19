package com.github.adamovichas.project.web.spring;

import com.github.adamovichas.project.service.data.IBetService;
import com.github.adamovichas.project.service.data.ICashAccountService;
import com.github.adamovichas.project.service.data.IEventService;
import com.github.adamovichas.project.service.data.IUserService;
import com.github.adamovichas.project.service.util.IUtil;
import com.github.adamovichas.project.service.util.event.IEventUtil;
import com.github.adamovichas.project.web.controller.AuthentificationController;
import com.github.adamovichas.project.web.controller.FileController;
import com.github.adamovichas.project.web.controller.MainPageController;
import com.github.adamovichas.project.web.controller.admin.AdminController;
import com.github.adamovichas.project.web.controller.admin.event.EventController;
import com.github.adamovichas.project.web.controller.user.UserController;
import com.github.adamovichas.project.web.controller.user.bet.BetController;
import com.github.adamovichas.project.web.controller.user.cashier.CashierController;
import com.github.adamovichas.project.web.validation.EventValidation;
import com.github.adamovichas.project.web.validation.Filevalidator;
import com.github.adamovichas.project.web.validation.IEventValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.github.adamovichas.project.web"})
public class WebConfig {

//    private ServiceConfig serviceConfig;
//
//    public WebConfig(ServiceConfig serviceConfig) {
//        this.serviceConfig = serviceConfig;
//    }

    @Bean
    public UrlBasedViewResolver tilesViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer(){
        final TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
        return tilesConfigurer;
    }

    @Bean
    IEventValidation eventValidation(){return new EventValidation();
    }

    @Bean
    MainPageController mainPageController(IEventService eventService){return new MainPageController(eventService);}

    @Bean
    AuthentificationController authentificationController(IUserService userService, IUtil util){
        return new AuthentificationController(userService, util);
    }

    @Bean
    AdminController adminController(ICashAccountService cashAccountService,IEventService eventService){
        return new AdminController(cashAccountService, eventService);
    }

    @Bean
    UserController userController(IUserService userService, IBetService betService){
        return new UserController(userService,betService);
    }

    @Bean
    CashierController cashierController(ICashAccountService cashAccountService){
        return new CashierController(cashAccountService);
    }

    @Bean
    EventController eventController(IEventService eventService, IEventValidation eventValidation, ICashAccountService cashAccountService){
        return new EventController(eventService,eventValidation,cashAccountService);
    }

    @Bean
    BetController betController(IEventService eventService, IEventUtil eventUtil, IBetService betService, ICashAccountService cashAccountService){
        return new BetController(eventService,eventUtil,betService,cashAccountService);
    }

    @Bean
    Filevalidator filevalidator(){
        return new Filevalidator();
    }

    @Bean
    FileController fileController(Filevalidator filevalidator){
        return new FileController(filevalidator);
    }

//    @Bean
//    ViewResolver viewResolver () {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/view/page/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
}