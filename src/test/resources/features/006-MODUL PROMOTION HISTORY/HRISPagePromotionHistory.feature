#Author: intanjuniar101@gmail.com
Feature: Bucket Promotion History

  @SearchBy
  Scenario Outline: Menampilkan data promosi berdasarkan "search" by
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User search by <word>
    Then Validasi search by <search> contain <word>

    Examples: 
      | search           | word       |
      | form             |        301 |
      | nama karyawan    | ADHITYA    |
      | tgl pengajuan    |       2022 |
      | tgl pengajuan    | 2022-07    |
      | tgl pengajuan    | 2022-06-30 |
      | appr status      | CECEP      |
      | kategori promosi | salary     |
      | requested by     | ZAKI       |

  @SearchBy
  Scenario Outline: Menampilkan data promosi berdasarkan "search" by IDReq [-]
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User search by <word>
    Then Validasi search by ID Req

    Examples: 
      | search     | word |
      | id request |  414 |

  @SortbyAsc_IDRequest
  Scenario: Menampilkan data promosi berdasarkan "SortbyAsc_IDRequest"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Ascending ID Request
    Then Data tampil
    And Validasi ascending kolom IDReq

  @SortbyDesc_IDRequest
  Scenario: Menampilkan data promosi berdasarkan "SortbyDesc_IDRequest"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Descending ID Request
    Then Data tampil
    And Validasi descending kolom IDReq

  @SortbyAsc_From
  Scenario: Menampilkan data promosi berdasarkan "SortbyAsc_From"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Ascending Form
    Then Data tampil
    And Validasi ascending kolom Form

  @SortbyDesc_Form
  Scenario: Menampilkan data promosi berdasarkan "SortbyDesc_Form"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Descending Form
    Then Data tampil
    And Validasi descending kolom Form

  @Sortby_NamaKaryawan
  Scenario: Menampilkan data promosi berdasarkan "Sortby_NamaKaryawan"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Ascending Nama Karyawan
    Then Data tampil
    And Validasi kolom nama

  @Sortby__NamaKaryawan
  Scenario: Menampilkan data promosi berdasarkan "Sortby__NamaKaryawan"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Descending Nama Karyawan
    Then Data tampil
    And Validasi kolom nama

  @SortbyAsc_TanggalPengajuan
  Scenario: Menampilkan data promosi berdasarkan "SortbyAsc_TanggalPengajuan" by
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Ascending Tanggal Pengajuan
    Then Data tampil
    And Validasi kolom Tgl Pengajuan

  @SortbyDesc_TanggalPengajuan
  Scenario: Menampilkan data promosi berdasarkan "SortbyDesc_TanggalPengajuan"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Descending Tanggal Pengajuan
    Then Data tampil
    And Validasi descending kolom Tgl Pengajuan

  @Sortby_ApproveStatus
  Scenario: Menampilkan data promosi berdasarkan "Sortby_ApproveStatus"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Ascending Approve Status
    Then Data tampil
    And Validasi kolom Appr

  @Sortby_ApproveStatus
  Scenario: Menampilkan data promosi berdasarkan "Sortby_ApproveStatus"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Descending Approve Status
    Then Data tampil
    And Validasi kolom Appr

  @Sortby_Kategori
  Scenario: Menampilkan data promosi berdasarkan "Sortby_Kategori" by
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Ascending Kategori
    Then Data tampil
    And Validasi ascending kolom kategori

  @Sortby_Kategori
  Scenario: Menampilkan data promosi berdasarkan "Sortby_Kategori"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Descending Kategori
    Then Data tampil
    And Validasi descending kolom kategori

  @Sortby_RequestedBy
  Scenario: Menampilkan data promosi berdasarkan "Sortby_RequestedBy"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Ascending Requested By
    Then Data tampil
    And Validasi kolom Request

  @Sortby_RequestedBy
  Scenario: Menampilkan data promosi berdasarkan "Sortby_RequestedBy"
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User sort by Descending Requested By
    Then Data tampil
    And Validasi kolom Request

  @Click_BtnSee
  Scenario: Action *Click_BtnSee*
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User menekan button see
    Then Data tampil

  @Click_BtnBack
  Scenario: Action *Click_BtnBack*
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User menekan button see
    And User menekan button kembali
    Then Data tampil

  @Show
  Scenario Outline: Menampilkan data promotion history by *ShowEntries*
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User memilih show of data <show>
    Then Data tampil
    And Validasi data promotion history by <show>

    Examples: 
      | show |
      |   10 |
      |   25 |
      |   50 |
      |  100 |

  @filter
  Scenario Outline: Menampilkan data promotion *filterByFrom*
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User memilih from date <from>
    And User memilih to date <to>
    Then Data tampil
    And Validasi filter <from> date <to>

    Examples: 
      | from       | to         |
      | 2022-07-11 | 2022-07-10 |
      | 2022-07-09 | 2022-07-09 |
      | 2022-07-09 | 2022-07-10 |
      |            | 2022-07-10 |
      | 2022-07-09 |            |

  @reset
  Scenario Outline: Perilaku button reset *buttonReset*
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User memilih from date <from>
    And User memilih to date <to>
    Then User menekan button reset
    And Validasi button reset

    Examples: 
      | from       | to         |
      | 2022-07-11 | 2022-07-10 |

  Scenario: Menampilkan data pada halaman berikutnya *nextButton*
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User menekan klik next
    Then Data tampil

  Scenario: Menampilkan data pada halaman sebelumnya *prevButton*
    Given User login sebagai Manager
    And User masuk pada Homepage
    When User menekan teks promotion pada Navigation Menu
    And User menekan Promotion History pada submenu Navigation
    And User menekan klik next
    And User menekan klik prev
    Then Data tampil
