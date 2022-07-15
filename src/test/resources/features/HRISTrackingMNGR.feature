#Author: maslachahawwaliyah@gmail.com
Feature: Request Staff Sub Menu Tracking

  #SEMUA VALIDASI DONE
  #==================== ===== POSITIF TEST ===== ====================#
  @logingTracking
  Scenario: Request Staff Tracking MNGR
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Tracking
    Then Validasi loging sub menu tracking

  #SHOW DATA
  #data tidak muncul setelah automation
  @showDataTracking
  Scenario: Request Staff Tracking MNGR show data
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Tracking
    And User melakukan show data pada sub menu tracking
    Then Data tampil
    And User validasi show data sesuai

  #DETAIL DATA
  @cekDetailData
  Scenario: Tracking MNGR cek detail data btn eye
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Tracking
    When User menekan button plus dan eye
    Then User validasi detail data permintaan baru

  #==================== ===== NEGATIF TEST ===== ====================#
  #Belum ada assert
  @cekFilterFT
  Scenario Outline: Pending MNGR cek fungsi filter
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Tracking
    And User melakukan cek filter data input tanggal from sub menu tracking <date1>
    And User melakukan input tanggal to sub menu tracking <date2>
    Then Data tidak berhasil tampil
    And Validasi filter <date1> date <date2>

    Examples: 
      | date1      | date2      |
      | 11-07-2022 | 12-07-2022 |
      | 11-07-2022 | 11-07-2022 |
      | 12-07-2022 | 11-06-2022 |
      |            |            |

  @cekSearchGagal
  Scenario Outline: Request Staff pending MNGR search data negatif test
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Tracking
    And User menjalankan search data berdasarkan search <search>
    Then Data tidak berhasil tampil

    Examples: 
      | search              |
      | ADHITYA BAYU W      |
      | Supervisor          |
      | 006/PM/HRD/VII/2022 |
      | Penggantian         |
      |                  50 |
      | Juara Coding Tebet  |
  #========================================================
