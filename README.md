# SYSNUTRI API/V.1.0

<b>Professor:</b> Fujioka
<br/>
<b>Disciplina:</b> Java Web I

Proposta do Trabalho descrito no seguinte link: <a href="https://github.com/felipecesargomes/pos-javaweb/blob/master/README.md" rel="nofollow">Readme.md do Trabalho da Pós Graduação</a></p></h2>

Finalidade: Projeto de JAVA WEB para a pós graduação. Tecnologias utilizadas:

<pre><code>
<li>REST</li>
<li>Maven</li>
<li>JDK11</li>
<li>SpringBoot</li>
<li>SpringData</li>
<li>DataJPA</li>
<li>DevTools</li>
<li>BootStrap</li>
<li>HTML/CSS</li>
<li>POSTGRES</li>
<li>Thymeleaf</li> </pre></code>

Classe Abstrata (@MappedSuperclass) para reaproveitar código para as Classes Paciente e Nutricionista

<table>
<thead>
<tr>
<th>PessoaAbstractEntity</th>
<th>Tipo</th>
</tr>
</thead>
<tbody>
<tr>
<td>id</td>
<td>Numérico</td>
</tr>
<tr>
<td>nome</td>
<td>Texto</td>
</tr>
<tr>
<td>sobrenome</td>
<td>Texto</td>
</tr>
<tr>
<td>rg</td>
<td>Texto</td>
</tr>
<tr>
<td>cpf</td>
<td>Texto</td>
</tr>
</tbody>
</table>

Entidades:
Alimentos, Consultas, Nutricionista, Paciente, PlanoSaude

<table>
<thead>
<tr>
<th>Paciente</th>
<th>Tipo</th>
</tr>
</thead>
<tbody>
<tr>
<td>altura</td>
<td>Integer Wrapper</td>
</tr>
<tr>
<td>sexo</td>
<td>ENUM</td>
</tr>
<tr>
<td>peso</td>
<td>Double Wrapper</td>
</tr>
<tr>
<td>imc</td>
<td>Texto</td>
</tr>
<tr>
<td>planoSaude</td>
<td>Plano Saude</td>
</tr>
<tr>
<td>dataCriacao</td>
<td>Data</td>
</tr>
<tr>
<td>dataNascimento</td>
<td>Data</td>
</tr>
</tbody>
</table>

<table>
<thead>
<tr>
<th>Alimentos</th>
<th>Tipo</th>
</tr>
</thead>
<tbody>
<tr>
<td>nomeAlimento</td>
<td>Texto</td>
</tr>
<tr>
<td>kcal</td>
<td>Double Wrapper</td>
</tr>
<tr>
<td>carb</td>
<td>Double Wrapper</td>
</tr>
<tr>
<td>prot</td>
<td>Double Wrapper</td>
</tr>
<td>gordTotais</td>
<td>Double Wrapper</td>
</tr>
<td>vitaminaA</td>
<td>Double Wrapper</td>
</tr>
<td>vitaminaB</td>
<td>Double Wrapper</td>
</tr>
<td>vitaminaC</td>
<td>Double Wrapper</td>
</tr>
<td>calcio</td>
<td>Double Wrapper</td>  
</tr>
<td>ferro</td>
<td>Double Wrapper</td> 
</tr>
</tbody>
</table>


<table>
<thead>
<tr>
<th>Nutricionista</th>
<th>Tipo</th>
</tr>
</thead>
<tbody>
<tr>
<td>crn</td>
<td>Texto</td>
</tr>
<tr>
<td>turnoAtendimento</td>
<td>ENUM</td>
</tr>
<tr>
<td>salario</td>
<td>BigDecimal</td>
</tr>
</tbody>
</table>

<table>
<thead>
<tr>
<th>Consultas</th>
<th>Tipo</th>
</tr>
</thead>
<tbody>
<tr>
<td>dataConsulta</td>
<td>Data</td>
</tr>
<tr>
<td>paciente</td>
<td>Paciente</td>
</tr>
<tr>
<td>nutricionista</td>
<td>Nutricionista</td>
</tr>
</tbody>
</table>

<table>
<thead>
<tr>
<th>Plano de Saúde</th>
<th>Tipo</th>
</tr>
</thead>
<tbody>
<tr>
<td>nome</td>
<td>Texto</td>
</tr>
</tbody>
</table>

<h1>Tela Inicial do Projeto</h1>
<img src="https://felipecesargomes.com.br/sysnutri-home.png" alt="" style="max-width:100%;">

<p align="justify">O projeto tem como ideia principal disponibilizar um sistema gerenciador para nutricionistas marcar consultas, elaborar dietas e acompanhar seus pacientes diante de relatórios de progressos, auxiliando para os mesmos tomarem as melhores decisões em relação aos seus pacientes. Essa é apenas a prévia do sistema no qual eu pretendo da prosseguimento em seu desenvolvimento, sempre melhorando.</p>

<img src="https://felipecesargomes.com.br/sysnutri.png" alt="" style="max-width:100%;">

<p align="justify">Para consultar por NOME, RG, CPF, clicar na descrição dos nomes na listagem, depois será aberto um model para digitar um nome para fazer a pesquisa no banco de dados e retornar no html.</p>

<h2>Configuração do Ambiente</h2>

<li>Usar JDK 11</li>
<li>Criar database no postgres com o nome de sysnutri</li>
<li>Converter o projeto para Maven</li>
<li>Fazer Update do repositorios do maven</li>
<li>Verificar conexão com a internet, pois a maior parte dos CSS estão no meu domínio próprio.</li>

<h2><p>Felipe César - <a href="https://www.linkedin.com/in/felipe-c%C3%A9sar-296145162/" rel="nofollow">LinkedIn</a></p></h2>
