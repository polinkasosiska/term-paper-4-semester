# term-paper-4-semester
term paper 4 semester



Введение

Мне было достаточно сложно определиться с темой, так как я хотела реализовать не просто многофункциональное приложение, но приложение которое в себе будет одинаково сочетать как современный стек технологий, так и дизайн с архитектурой. В силу недавних политических событий - многие приложения были запрещены на территории РФ, поэтому мной было решено реализовать сегодня те проекты, в которых сейчас нуждается наше общество. Как смешно это не было, но выбор пал на Instagram, я не фанат данной платформы, но современные способы продвижения продукта именно завязаны на ней, а альтернативной площадки на данный момент нет. В российских реалиях данная соц сеть это не просто место, где люди выкладывают красивые фотки с отдыха, а это наимощнейший инструмент маркетинга. Но так как я не являюсь фанатом данной соц сети, я решила немного сделать шуточную версию данной сети, а именно - соцсеть для котов “Кэтаграм”. Но шутки шутками, но идея создать соцсеть для наших пушистых друзей у меня возникла не просто так. В дальнейшем я в свое приложение хочу добавить интерактивную карту, для поиска потерявшихся животных. Данное приложение в дальнейшем может превратиться не только в маркетинговый инструмент как Инстаграм, но в социально значимый проект для многих людей.



Разработка концепта и дизайна

После определения с темой, встал вопрос о том, какое будет мое будущее приложение. Я решила обратиться к популярному сервису для проектирования будущих приложений - https://www.figma.com/
Вначале мной был создал примерный дизайн макет, в дальнейшем дизайн моего приложения немного измениться, так я буду его дорабатывать. В процессе разработки я поняла, что из меня плохой дизайнер, и реализовать модный material u я не в силах, поэтому я решила, что плохой дизайн надо сделать главной фишкой моего приложения! Но плохой это только пока что на стадии разработки, я решила пойти по пути дизайнеров интерьеров и маркетологов. Не качественный продукт? Нет, это дизайнерское решение! Поэтому мое приложение как модные лофт интерьеры приобрели своего дизайнера в помощь, а неопрятные решения -стали главной фишкой. Так как процесс у нас уже творческий, я решила, что реализовать неопрятный дизайн мне лучше всего сможет моя 8 летняя сестра! Составив ей техническое задание, и проведя обучение по использованию рисования векторной графики я на выходе получила примерно такой макет моего будущего дизайна:


На данный момент, было все еще не очень, но детские рисунки уже добавили определенного шарма и направление дизайна было ясно!

Сам дизайн я непосредственно доделывала уже во время разработки, но где-то в середине процесса появилось понимание, что придется делать кастомные кнопки, поэтому обратившись уже за помощью к своей старшей сестре, были реализованы будущие макеты кнопок для приложения, вот такие вышли:




В дальнейшем концепт дизайна деталей еще мной дорабатывался неоднократно. Ниже представлены уже итоговые концепты элементов управления:











Разработка приложения

К сожалению я не успела полностью реализовать свое приложение, но основной функционал уже есть.

Поговорим о ролевых моделях: у меня их всего 2 пока что, но в дальнейшем 
у меня их будет больше.

Так как я увлекаюсь информационной безопасностью, я реализовала ролевые модели на разных клиентах ( данный способ использует например Аэрофлот, количество их серверов и клиентов не знают даже их сотрудники из ИТ, Аэрофлот в этом плане реализовали очень сложную систему после многомиллионных краж, и за счет такой сложной системы больше 10 лет уже не происходят крупные утечки данных или денежных средств ). Всего у меня получилось 3 клиента, два независимых и один объединяющих, следовательно у меня получился граф с элементами JSON.

















Клиент админа

Клиент админа является простейшей реализацией моего приложения, так как у нас есть окно регистрации, входа и окно с взаимодействием с сервисом.
Ниже представлены скрина клиента админа.











Структура клиента админа не сложная, она выглядит следующим образом:









Код Активити также не сложный, поэтому предлагаю рассмотреть только код регистрации и авторизации, которые представлены ниже:

Код авторизации:
package com.example.catgram_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
   private FirebaseFirestore db;
   private FirebaseAuth mAuth;
   private EditText editTextEmail;
   private EditText editTextPassword;
   private Button buttonLogin;
   private TextView textViewRegister;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);

       db = FirebaseFirestore.getInstance();
       mAuth = FirebaseAuth.getInstance();

       editTextEmail = findViewById(R.id.editTextEmailAddress);
       editTextPassword = findViewById(R.id.editTextTextPassword);
       buttonLogin = findViewById(R.id.buttonLogin);
       textViewRegister = findViewById(R.id.textViewRegister);

       textViewRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
               startActivity(intent);
           }
       });

       buttonLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email = editTextEmail.getText().toString().trim();
               String password = editTextPassword.getText().toString().trim();

               if (email.isEmpty() || password.isEmpty()) {
                   return;
               }

               mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Intent intent = new Intent(LoginActivity.this, WebActivity.class);
                           startActivity(intent);
                       } else {
                           Toast.makeText(LoginActivity.this, "Ошибка " + task.getException(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });
           }
       });
   }
}
Код регистрации:
package com.example.catgram_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class RegisterActivity extends AppCompatActivity {
   private FirebaseFirestore db;
   private FirebaseAuth mAuth;
   private TextView textView;
   private EditText editTextEmail;
   private EditText editTextPassword;
   private Button buttonRegister;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_register);

       db = FirebaseFirestore.getInstance();
       mAuth = FirebaseAuth.getInstance();

       buttonRegister = findViewById(R.id.buttonRegister);

       textView = findViewById(R.id.textViewLogin);
       editTextEmail = findViewById(R.id.editTextEmail);
       editTextPassword = findViewById(R.id.editTextPassword);

       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
               startActivity(intent);
           }
       });
       buttonRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email = editTextEmail.getText().toString().trim();
               String password = editTextPassword.getText().toString().trim();

               if (email.isEmpty() || password.isEmpty()) {
                   return;
               }

               mAuth.createUserWithEmailAndPassword(email, password)
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override

                           public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                   startActivity(intent);
                               } else {
                                   Toast.makeText(RegisterActivity.this, "Ошибка " + task.getException(), Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
           }
       });
   }
}











Клиент пользователя
Структура клиента пользователя в разы сложнее структуры админа, ниже представлена его структура:




Проект получился действительно большим, поэтому весь код описать не выйдет, предлагаю посмотреть элементы управления, а также работу с мультимедией, регистрация и авторизация практически такая же как у клиента админа.

Элементы управления:
package com.example.my_catgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity1 extends AppCompatActivity {

   private Button button;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_info1);
       button = findViewById(R.id.button);
       /*
   public void onClick(View view) {
       Intent intent = new Intent(this, EmailPasswordActivity.class);
     iew.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(InfoActivity1.this, InfoActivity2.class);
               startActivity(intent);
           }
       });
   }
}  intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
       startActivity(intent);

   }

Код действительно не сложный, так я использовался обычный Intent и не более того.

Мультимедиа

Вот тут уже работа интереснее, так как я реализовала работу невидимых кнопок с помощью style="?android:attr/borderlessButtonStyle"
, вот так они расположены:


Код данного активити представлен ниже:
package com.example.my_catgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoActivity1 extends AppCompatActivity {

   VideoView videoPlayer;



   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_video1);



       videoPlayer = findViewById(R.id.videoPlayer);
       Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.cat1);
       videoPlayer.setVideoURI(myVideoUri);


   }

   public void play(View view){
       videoPlayer








Работа с сервисом
Мой выбор пал на firebase, так как это удобный сервис, реализующий работу сетевого БД, на данный момент я реализовала в нем только работу авторизации, но в дальнейшем планирую еще и комментарии.

Через консоль очень удобно работать с БД:









Заключение
В ходе данной курсовой работы, мной было реализовано приложение с несколькими клиентами и реализована работа сетевой БД. Данная работа дала мне опыт разработки объемного приложения. В дальнейшем я хочу продолжить развивать данную тему и усовершенствовать. В ходе данной курсовой работы мной также был повторен материал всего семестра. Написанное мной приложение работает корректно.


