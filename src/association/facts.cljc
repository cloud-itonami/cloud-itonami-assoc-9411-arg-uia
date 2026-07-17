(ns association.facts
  "Industry rule/history catalog for the Unión Industrial Argentina
  (UIA) -- a 57th industry-association-level source (see
  cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko, -9411-irl-ibec,
  -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii, -9411-zaf-busa,
  -9411-bra-cni, -9411-ken-kam, -9411-can-chamber, -9411-mex-coparmex,
  -9411-ita-confindustria, -9411-nld-vnoncw, -9411-kor-kcci for the
  first fourteen) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). The FIFTEENTH entry
  aligned to ISIC 9411 (activities of business, employers, and
  professional membership organizations). Fills Argentina's
  previously-open association-axis gap (one of the 13-country gap
  list recorded at tick 149) -- Argentina now has real, individually
  verified facts across ALL THREE axes (country:
  cloud-itonami-iso3166-arg statute.facts; municipality:
  cloud-itonami-municipality-arg-buenos-aires; association: this
  entry).

  The 7 February 1887 founding date is QUADRUPLY corroborated:
  uia.org.ar's own official '130 años' article
  (https://www.uia.org.ar/general/2467/130-anos-trabajando-por-el-desarrollo-industrial/),
  directly read, states verbatim 'Un lunes 7 de febrero de 1887,
  representantes de las dos entidades que nucleaban a los
  industriales argentinos deciden integrarse'; Argentina's own
  national government site (argentina.gob.ar), directly read,
  independently states verbatim 'Un 7 de febrero de 1887, con la
  celebración de una asamblea que convocó a 900 personas, se dio
  origen a la Unión Industrial Argentina'; es.wikipedia.org's own
  article states the same date; and Wikidata Q4789403's own
  'inception' statement lists '7 February 1887 (Gregorian calendar)',
  citing Argentina's official government site as its reference. The
  27 September 1913 inauguration of UIA's first own headquarters (at
  Cangallo 2461, Buenos Aires) is directly WebFetch-verified against
  es.wikipedia.org's own article.

  A REJECTED SOURCE ERROR: uia.org.ar's own '125 aniversario' page
  (https://uia.org.ar/general/1593/la-uia-conmemora-su-125-aniversario/)
  states verbatim 'En 1785 se funda el Club Industrial Argentino' --
  this 1785 date for a predecessor organization is historically
  implausible (predating Argentina's own 1816 independence) and
  contradicts independent secondary sources placing this predecessor's
  founding around 1875. Rather than treat 'directly quoted from an
  official page' as sufficient on its own, this specific claim was
  DISCARDED as an apparent typo/error on the source page itself and
  is NOT included in `catalog` -- a concrete instance of this
  project's 'never fabricate' discipline extending to 'never uncritic-
  ally propagate an implausible primary-source error' as well. The
  first president's name (Antonino/Antonio Cambaceres), incidentally
  encountered on multiple pages, is NOT persisted here.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"uia"
   [{:association-rule/id "uia.founding-1887-02-07"
     :association-rule/title "Unión Industrial Argentina (UIA) founded 7 February 1887 via a merger of two predecessor industrial associations, at an assembly of ~900 people (uia.org.ar official '130 años' article, independently corroborated by Argentina's own government site argentina.gob.ar, es.wikipedia.org, and Wikidata Q4789403's inception statement)"
     :association-rule/association "uia"
     :association-rule/isic "9411"
     :association-rule/country "ARG"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.uia.org.ar/general/2467/130-anos-trabajando-por-el-desarrollo-industrial/"
     :association-rule/url-provenance :official-uia-org-ar
     :association-rule/established-date "1887-02-07"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:governance}}
    {:association-rule/id "uia.first-own-headquarters-1913"
     :association-rule/title "UIA inaugurated its first own headquarters, at Cangallo 2461 (today Presidente Perón), Buenos Aires, on 27 September 1913 (es.wikipedia.org, matching an independent WebSearch corroboration)"
     :association-rule/association "uia"
     :association-rule/isic "9411"
     :association-rule/country "ARG"
     :association-rule/kind :governance-program
     :association-rule/url "https://es.wikipedia.org/wiki/Uni%C3%B3n_Industrial_Argentina"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/established-date "1913-09-27"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-arg-uia Wave 0 (ADR-2607141700): "
                 (count (get catalog "uia")) " UIA entries seeded "
                 "with uia.org.ar official + argentina.gob.ar government + Wikipedia/Wikidata "
                 "Q4789403 corroboration (a separate 1785 predecessor-founding claim on uia.org.ar "
                 "was rejected as an apparent source error, not fabricated around). "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
