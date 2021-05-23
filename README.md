<!--
Copyright (c) 2020 Osvaldo Airon

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
-->
Flutter Embacardo :iphone: :alien:
====
<p> 
    Essa POC tem como objetivo demonstrar o uso do flutter como embarcado para o Android utilizando uma arquitetura MVP e protocolo de comunicação através de method channels.
    Baixe o código fonte e utilize como base para seus aplicativos! ;]
</p>


## Arquitetura de Integração Android x Flutter

![Screenshot](flow_flutter_native.png 'Flow')

## Sumário
- [Iniciando...]
- Android AAR
- Android Architeture

## Iniciando...
    Inicialmente é necessário criar o modulo flutter contendo toda a configuração de rotas e paginas do seu app flutter.
    Utilize o comando flutter create -t module --org com.demo demo_module_flutter
    Agora com o modulo criado é necessario configurar o roteamento do app como tambem a comunicação com os method channels
    /Acesse o codigo fonte de demonstracao/
    
    
## Android AAR
    * Uma vez que configurado o modulo flutter deve-se gerar o artefato AAR utilize o comando flutter build aar no path do seu modulo flutter.
    * Coloque as seguintes linhas de codigo no build.gradle do app (android)
    * Sera necessario colocar tambem no build.gradle os filtros de ndk suportados pelo flutter
    * Coloque dentro do defaultConfig
    * ndk {
            // Filter for architectures supported by Flutter.
            abiFilters 'armeabi-v7a', 'arm64-v8a', 'x86_64'
        }
    * Dentro do settings.gradle adicione (Se não houver)
    * setBinding(new Binding([gradle:this]))

     * evaluate(new File(
        settingsDir.parentFile,
        'demo_module_flutter/.android/include_flutter.groovy'))
     * Por fim, faça o sync do build gradle.
    

![Screenshot](output_aar.png 'OutPut')


## Android Architeture

![Screenshot](core.png 'Core')

    * Dentro do pacote core/flutter é possivel acessar as classes de configuração android x flutter
    * O flutterCoreEngine permite criar e inicializar o motor flutter.
    * Esta classe depende da flutterNavigatorManager que configura o start a uma rota flutter especifica.
    Como tambem o FlutterChannelManager que faz a comunicação bidirecional android x flutter e flutter x android
    
    
![Screenshot](mvp_arch.png 'MVP')    
    
    * Dentro do pacote core/architeture é possivel acessar as classes de configuracao do MVP
    * Existem interfaces/classes necessarias que devem ser extendidas para serem utilizadas pela feature mvp.
    * Como no exemplo acima para a feature home.
    


