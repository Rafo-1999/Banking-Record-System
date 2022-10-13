                                                               Banking Record System

        Գրել եմ ծրագիր,որը տրամադրում  է կոնսոլային ինտերֆեյս  բանկի աշխատակցի համար,հաշիվներ ավելացնելու և կառավարելու համար։
        Ծրագիրը գրել եմ java ծրագրավորման լեզվի միջոցով։
        Ծրագիրը գրել եմ Intellij IDEA-ով, գրելուց օգտագործել եմ հետևյալ տեխնոլոգիաները՝ 
        Java Core,
        Java OOP, 
        JDBC, 
        PostgresSQL database, 
        SQL, 
        Maven, 
        Docker,
        Git,Github
        Ubuntu terminal 

                                                                     Աշխատանքը

        Console application է,որը աշխատացնելուց օգտվողից հարցում է կատարում թե ,որ գործառույթից է ցանկանում օգտվել,ցույց է տալիս ընտրելու տարբերակները և տալիս ընտրելու հնարավորություն։
        5 տարբերակ է ներառված
        N1 -> Create Account
        N2 -> See all accounts
        N3 -> Transfer Money
        N4 -> Delete Account
        N5 -> Exit the Program
        ու նաև Input Number->  դաշտ,որտեղ համապատասխան թիվը գրելով,,կոնկրետ հրամանն է աշխատում։Եթե օգտվողի կողմից թիվ չի գրվում այլ տառ կամ ուրիշ սիմվոլ ապա տպվում է էկրանին  «"Input valid data!"»
        N1 -> Create Account ընտրելով  հնարավորություն է տրվում մուտքագրելու հաճախորդի անունը,ազգանունը և հաշվեհամարը։Տվյալները մուտքագրելուց հետո ցույց է տալիս,որ ստեղծվել է user-ի account-ը և նաև թե,որերորդ accountn էր դա։
        N2 -> See all accounts  ընտրելով ցույց է տալիս բոլոր ներմուծված account-ների անունները։
        N3 -> Transfer Money  հնարավորություն է տալիս, մի account-ի հաշվից մյուսը գումար փոխանցել։Հարցում է կատարում ,որ օգտվողը նշի accountID-ները թե,որ account ից դեպի որն է փոխանցելու ու նաև գումարի չափը։
        N4 -> Delete Account  ընտրելով օգտվողից հարցնում է  accountID-ն ,որը որ  ցանկանում է ջնջել և ջնջում է account-ը։
        N5 -> Exit the Program  ընտրելով էլ ուղակի ավարտում է ծրագրի աշխատանքը և դուրս գալիս։

                                                                     Կառուցվածքը
        Ծրագիրը ստեղծել եմ 2-րդ փորձից,,առաջին դեպքում ստեղծել եմ mysql տվյալների բազա (տերմինալով),ու նաև mysql ի workbench,որի վրա բազա ստեղծելուց  , url-ն տալուց և դրիվերը նստացնելուց հետո,mysql java connector ֆայլն էր ուզում իրա դիրեկտորիայում install անել,,առաջին փորձից db ին նորմալ կպնում էր,սակայն համակարգիչը restart անելուց հետո mysql ի սերվերը run չէր լինում քանի որ դրիվեր-ը կորում էր ու ամեն անգամ նորից install ուզում։
        Երկրորդ դեպքում   postgreSQL  DB եմ ստեղծել: Ստեղծել եմ նոր պրոյեկտ իրա build system -maven տալով։  Connect-ը docker-ով եմ արել,docker-compose.yml ֆայլի մեջ իրա շաբլոնը տալով ,տվյալ դեպքում ստեղծվում է նաև pom.xml ֆայլը,որի մեջ maven ի dependecie-ն եմ դրել։Այս դեպքում առավելությունը նա է ,որ ամեն restartից հետո connectը ավտոմատ է անում։
        Ստեղծել եմ DbConnectioն․java class-ը ,որի վրա db ի connection եմ գրել։
        Ստեղծել եմ AccountServiceImpl կլասը,որի մեջ գրել եմ բոլոր մեթոդները,որը իմպլեմենտում է  AccountService-ից ,որտեղ կլասի իրականացման ֆունկցիոնալ հատվածն է։
        Ստեղծել եմ User և BankAccaunt ,որոնց մեջ հայտարված են համապատասխան փոփոխականները։
        DB-ում ստեղծվել են բանկի accountի ,որի մեջ ներմուծված է օգտվողի հաշվեհամարը և balance-ը,ու օգտվողի account-ը ,որի մեջներառված են օգտվողի անունը ազգանունը և հաշվեհամարը։
        Թեստավորումը իրականացրել եմ Main կլասի միջոցով,,որտեղ ամեն մեթոդ կանչել եմ և տարբեր արժեքներով արժեքավորրել,ու համապատասխան exception ների պայմանները գրել։
        Ստեղծել եմ Github-ի repozitory և ներառել պրոյեկտը,master branch -ում։ 
        Coding Style-ը google -ի checkstyle.xml ֆայլի միջոցով եմ արել։
